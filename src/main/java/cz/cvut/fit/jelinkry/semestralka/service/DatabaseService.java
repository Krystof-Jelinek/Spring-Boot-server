package cz.cvut.fit.jelinkry.semestralka.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import jakarta.transaction.Transactional;

@Service
public class DatabaseService {
    
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Value("classpath:insert_script.sql")
    private String insertScriptLocation;
    
    @Value("classpath:clean_script.sql")
    private String cleanScriptLocation;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void executeInsertScript() {
        try {
            // Read the content of the SQL script
            Path path = ResourceUtils.getFile(insertScriptLocation).toPath();
            String scriptContent = new String(Files.readAllBytes(path));

            // Execute the script using JDBC
            jdbcTemplate.execute(scriptContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void executeCleanScript() {
        try {
            // Read the content of the SQL script
            Path path = ResourceUtils.getFile(cleanScriptLocation).toPath();
            String scriptContent = new String(Files.readAllBytes(path));

            // Execute the script using JDBC
            jdbcTemplate.execute(scriptContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
