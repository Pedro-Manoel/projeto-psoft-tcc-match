package com.ufcg.psoft.tccMatch.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResponseError {

    public static void config (HttpServletResponse response, String message) throws IOException {
        Map<String, Object> responseMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        responseMap.put("error", message);
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("UTF-8");
        String responseMsg = mapper.writeValueAsString(responseMap);

        response.getWriter().write(responseMsg);
    }
}
