package ru.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController {

    @Autowired
    private Config config;

    @GetMapping(value = "/config")
    public ResponseEntity<ConfigDto> getConfigs(@RequestParam("name") String name) {
        return ResponseEntity.ok(config.getConfigByHash(name.hashCode() % 2));
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<List<ConfigDto>> getConfigs() {
        return ResponseEntity.ok(config.getConfigs());
    }
}
