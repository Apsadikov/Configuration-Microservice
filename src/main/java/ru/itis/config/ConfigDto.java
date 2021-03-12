package ru.itis.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConfigDto {
    private String ip;

    private int port;

    private int hash;

    private String user;

    private String password;

}
