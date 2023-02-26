package com.musinsa.menuservice.util.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.menuservice.domain.banner.entity.Banner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Converter(autoApply = true)
public class MenuBannerConverter implements AttributeConverter<Banner, String> {

    @Override
    public String convertToDatabaseColumn(Banner banner) {
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(banner);

        } catch (JsonProcessingException e) {
            log.error("failed to parse database. dto to string");
            return "";
        }
    }

    @Override
    public Banner convertToEntityAttribute(String dbData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(dbData, Banner.class);

        } catch (JsonProcessingException e) {
            log.info("failed to parse database. string to array");
            return null;
        }
    }

}
