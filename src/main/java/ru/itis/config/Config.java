package ru.itis.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Config {

    @Getter
    private List<ConfigDto> configs;

    public Config() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is;
        try {
            is = new ClassPathResource("/config.json").getInputStream();
            configs = mapper.readValue(is, new TypeReference<List<ConfigDto>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            configs = new ArrayList<>();
        }
    }

    public ConfigDto getConfigByHash(int hash) {
        Optional<ConfigDto> configDto = configs.stream().filter(config -> config.getHash() == hash).findFirst();
        if (configDto.isPresent()) {
            return configDto.get();
        } else {
            throw new IllegalArgumentException("Config not found by specified hash");
        }
    }
}
