package br.com.project.sistema.gerenciador.conta.infraestructure.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Map;

@Slf4j
public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    public static final ObjectMapper om = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        String attributeJson = null;
        try {
            attributeJson = om.writeValueAsString(attribute);
        }catch (final JsonProcessingException e) {
            log.error("JSON writing error.", e);
        }
        return attributeJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        Map<String, Object> attributeInfo = null;
        try {
            attributeInfo = om.readValue(dbData, Map.class);
        }catch (final IOException e) {
            log.error("JSON reading error.", e);
        }

        return attributeInfo;
    }
}
