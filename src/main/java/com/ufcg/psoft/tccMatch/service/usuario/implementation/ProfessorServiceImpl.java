package com.ufcg.psoft.tccMatch.service.usuario.implementation;

import com.ufcg.psoft.tccMatch.dto.message.MessageDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.ProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.QuotaProfessorDTO;
import com.ufcg.psoft.tccMatch.dto.usuario.UsuarioDTO;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeJaExisteException;
import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.mapper.usuario.ProfessorMapper;
import com.ufcg.psoft.tccMatch.mapper.usuario.UsuarioMapper;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.model.usuario.Professor;
import com.ufcg.psoft.tccMatch.repository.usuario.ProfessorRepository;
import com.ufcg.psoft.tccMatch.service.usuario.ProfessorService;
import com.ufcg.psoft.tccMatch.service.usuario.UsuarioService;
import io.jsonwebtoken.lang.Collections;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    private final ProfessorMapper professorMapper;
    private final UsuarioMapper usuarioMapper;

    public Professor getProfessor (Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoExisteException("Professor", "id", id.toString()));
    }

    public void salvarProfessor (Professor professor) {
        professorRepository.save(professor);
    }
    
    public ProfessorDTO criarProfessor(ProfessorDTO professorDTO) {
        usuarioService.verificarUsuario(professorDTO);

        Professor professor = professorMapper.toEntity(professorDTO);
        String senhaCriptografada = passwordEncoder.encode(professorDTO.getSenha());
        professor.setSenha(senhaCriptografada);
        salvarProfessor(professor);

        return professorMapper.toDTO(professor);
    }
    
    public ProfessorDTO atualizarProfessor(Long id, ProfessorDTO professorDTO) {
        Professor professor = getProfessor(id);

        usuarioService.verificarUsuario(professor, professorDTO);

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

    public List<Professor> getProfessores () { return professorRepository.findAll(); }

    public List<UsuarioDTO> listarProfessoresDisponiveisOrientacaoTcc (List<AreaEstudo> areasEstudo) {
        List<Professor> professoresComQuota = professorRepository.findByQuotaGreaterThanEqual(1);
        List<UsuarioDTO> professoresDTO = new ArrayList<>();

        for (Professor professorComQuota : professoresComQuota) {
            if (Collections.containsAny(professorComQuota.getAreasEstudo(), areasEstudo)) {
                professoresDTO.add(usuarioMapper.toDTO(professorComQuota));
            }
        }

        return professoresDTO;
    }
}
