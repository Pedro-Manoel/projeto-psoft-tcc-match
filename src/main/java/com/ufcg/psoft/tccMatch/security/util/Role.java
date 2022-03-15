package com.ufcg.psoft.tccMatch.security.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    public static final String USER_ADMIN = "ROLE_USER_ADMIN";
    public static final String USER_ALUNO = "ROLE_USER_ALUNO";
    public static final String USER_PROF = "ROLE_USER_PROF";

    private String authority;
}
