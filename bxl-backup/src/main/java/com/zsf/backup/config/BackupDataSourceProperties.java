package com.zsf.backup.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bxl.backup.datasource")
@Data
public class BackupDataSourceProperties {
    private String host;
    private String username;
    private String password;
    private String database;
}
