package com.ufcg.psoft.tccMatch.service.implementation;

import com.ufcg.psoft.tccMatch.dto.*;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.ProfessorMapper;
import com.ufcg.psoft.tccMatch.mapper.TemaTccMapper;
import com.ufcg.psoft.tccMatch.mapper.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.TemaTcc;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.model.usuario.UsuarioTcc;
import com.ufcg.psoft.tccMatch.repository.ProfessorRepository;
import com.ufcg.psoft.tccMatch.service.ProfessorService;
import com.ufcg.psoft.tccMatch.service.TemaTccService;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import io.jsonwebtoken.lang.Collections;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    private final UsuarioService usuarioService;
    private final TemaTccService temaTccService;
    private final TemaTccMapper temaTccMapper;
    private final PasswordEncoder passwordEncoder;

    private final ProfessorMapper professorMapper;
    private final UsuarioMapper usuarioMapper;

    private Professor getProfessor (Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Professor", "id", id.toString()));
    }

    private void salvarProfessor (Professor professor) {
        professorRepository.save(professor);
    }
    
    public ProfessorDTO criarProfessor(ProfessorDTO professorDTO) {
        if (usuarioService.usuarioJaExiste(professorDTO)) {
            throw new EntidadeJaExisteException("Professor", "email", professorDTO.getEmail());
        }

        Professor professor = professorMapper.toEntity(professorDTO);
        String senhaCriptografada = passwordEncoder.encode(professorDTO.getSenha());
        professor.setSenha(senhaCriptografada);
        salvarProfessor(professor);

        return professorMapper.toDTO(professor);
    }
    
    public ProfessorDTO atualizarProfessor(Long id, ProfessorDTO professorDTO) {
        Professor professor = getProfessor(id);

        if (usuarioService.usuarioJaExiste(professor, professorDTO)) {
            throw new EntidadeJaExisteException("Professor", "email", professorDTO.getEmail());
        }

        String senhaCriptografada = passwordEncoder.encode(professorDTO.getSenha());
        professorDTO.setSenha(senhaCriptografada);
        professorMapper.toUpdateEntity(professorDTO, professor);
        salvarProfessor(professor);

        return professorMapper.toDTO(professor);
    }

   
    public MessageDTO removerProfessor(Long id) {
        Professor professor = getProfessor(id);

        professorRepository.delete(professor);

        return new MessageDTO(
                String.format("Professor com id <%s> foi removido com sucesso do sistema", id)
        );
    }
    
    public ProfessorDTO atualizarQuotaProfessor(Long id, QuotaProfessorDTO quotaProfessorDTO) {
        Professor professor = getProfessor(id);

        professor.setQuota(quotaProfessorDTO.getQuota());
        salvarProfessor(professor);

        return professorMapper.toDTO(professor);
    }

    public List<TemaTccUsuarioDTO> listarTemasTccProfessores() {
        List<Professor> professores = professorRepository.findAll();
        List<TemaTccUsuarioDTO> temasTccProfessores = new ArrayList<>();


        for (UsuarioTcc professor : professores) {
            temasTccProfessores.addAll(temaTccService.listarTemasTccUsuario(professor));
        }

        return temasTccProfessores;
    }

    public List<TemaTccDTO> listarTemasTccProfessor(Long id) {
        Professor professor = getProfessor(id);
        List<TemaTcc> temasTccProfessore = professor.getTemasTcc();

        return temaTccMapper.toDTOs(temasTccProfessore);
    }

    public List<ProfessorDTO> listarProfessoresDisponiveisOrientacao (List<AreaEstudo> areasEstudo) {
        List<Professor> professoresComQuota = professorRepository.findByQuotaGreaterThanEqual(1);
        List<ProfessorDTO> professores = new ArrayList<>();

        for (Professor professorComQuota : professoresComQuota) {
            if (Collections.containsAny(professorComQuota.getAreasEstudo(), areasEstudo)) {
                professores.add(professorMapper.toDTO(professorComQuota));
            }
        }

        return professores;

    }
}
