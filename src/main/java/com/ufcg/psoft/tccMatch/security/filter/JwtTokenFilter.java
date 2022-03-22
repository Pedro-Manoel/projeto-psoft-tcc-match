package com.ufcg.psoft.tccMatch.security.filter;

import com.ufcg.psoft.tccMatch.error.exception.EntidadeNaoExisteException;
import com.ufcg.psoft.tccMatch.security.error.exception.TokenInvalidoException;
import com.ufcg.psoft.tccMatch.security.util.JwtTokenUtil;
import com.ufcg.psoft.tccMatch.security.service.Implementation.JwtUserDetailsService;
import com.ufcg.psoft.tccMatch.security.util.MyUserDetail;
import com.ufcg.psoft.tccMatch.security.util.ResponseError;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtUserDetailsService jwtUserDetailsService;

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        try {
            if (authHeader != null && authHeader.startsWith("Bearer ")) {

                final String authToken = authHeader.substring(7);

                if (jwtTokenUtil.validateToken(authToken)) {
                    final String username = jwtTokenUtil.getUsername(authToken);

                    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        MyUserDetail myUserDetail = jwtUserDetailsService.loadUserByUsername(username);

                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        myUserDetail,
                                        null,
                                        myUserDetail.getAuthorities()
                                );

                        authentication.setDetails(
                                new WebAuthenticationDetailsSource().buildDetails(request)
                        );

                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        } catch (TokenInvalidoException ex) {
            ResponseError.config(response, ex.getMessage());
            return;
        } catch (EntidadeNaoExisteException ex) {
            ResponseError.config(response, "O usuário que consta no token não existe no sistema");
            return;
        }

        chain.doFilter(request, response);
    }
}
