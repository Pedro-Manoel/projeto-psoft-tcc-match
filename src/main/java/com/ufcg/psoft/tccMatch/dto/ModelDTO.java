package com.ufcg.psoft.tccMatch.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ModelDTO {
    @Hidden
    private Long id;

    private Map<String, Object> properties;

    public ModelDTO () { this.properties = new HashMap<>(); }

    public void addPropertie (String propertie, Object value) {
        this.properties.put(propertie, value);
    }

    @JsonAnyGetter
    @Hidden
    public Map<String, Object> getProperties () { return this.properties; }

    @Hidden
    public void setProperties (Map<String, Object> map) { this.properties = map; }
}
