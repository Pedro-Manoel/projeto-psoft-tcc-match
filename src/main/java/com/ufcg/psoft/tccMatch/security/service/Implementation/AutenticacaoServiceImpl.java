package com.ufcg.psoft.tccMatch.security.service.Implementation;

import com.ufcg.psoft.tccMatch.model.usuario.Usuario;
import com.ufcg.psoft.tccMatch.security.dto.LoginDTO;
import com.ufcg.psoft.tccMatch.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.security.exception.LoginInvalidoException;
import com.ufcg.psoft.tccMatch.security.util.JwtTokenUtil;
import com.ufcg.psoft.tccMatch.security.dto.TokenDTO;
import com.ufcg.psoft.tccMatch.security.service.AutenticacaoService;
import com.ufcg.psoft.tccMatch.security.util.MyUserDetail;
import com.ufcg.psoft.tccMatch.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AutenticacaoServiceImpl implements AutenticacaoService {

    private final JwtUserDetailsService jwtUserDetailsService;
    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public TokenDTO autenticar(LoginDTO loginDTO) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                            loginDTO.getSenha()
                    )
            );

            if (auth.isAuthenticated()) {
                MyUserDetail myUserDetail = jwtUserDetailsService.loadUserByUsername(loginDTO.getEmail());

                String token = jwtTokenUtil.generateToken(myUserDetail);

                return new TokenDTO(token);
            } else {
                throw new LoginInvalidoException();
            }
        } catch (BadCredentialsException | EntidadeNaoExisteException | InternalAuthenticationServiceException ex) {
            throw new LoginInvalidoException();
        }
    }

    public Long getIdUsuarioAutenticado () {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        MyUserDetail myUserDetail = (MyUserDetail) auth.getPrincipal();

        return myUserDetail.getId();
    }
}

