package com.ufcg.psoft.tccMatch.notification.mapper;

import com.ufcg.psoft.tccMatch.dto.AreaEstudoDTO;
import com.ufcg.psoft.tccMatch.model.AreaEstudo;
import com.ufcg.psoft.tccMatch.notification.dto.EmailDTO;
import com.ufcg.psoft.tccMatch.notification.model.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EmailMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "data", source = "data", dateFormat = "dd/MM/yyyy - HH:mm")
    EmailDTO toDTO (Email email);

    List<EmailDTO> toDTOs (List<Email> emails);
}
