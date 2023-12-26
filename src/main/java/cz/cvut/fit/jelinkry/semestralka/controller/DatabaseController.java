package cz.cvut.fit.jelinkry.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.service.DatabaseService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/database")
    public ResponseEntity<String> executeDataScript() {
        databaseService.executeDataScript();
        return ResponseEntity.ok("Data script executed successfully");
    }
}
