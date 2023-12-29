package cz.cvut.fit.jelinkry.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.service.DatabaseService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/database")
    public ResponseEntity<String> executeInsertScript() {
        try{
            databaseService.executeInsertScript();
            return ResponseEntity.ok("Insert script executed successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to execute data script: " + e.getMessage());
        }
    }

    @DeleteMapping("/database")
    public ResponseEntity<String> executeCleanScript() {
        try{
            databaseService.executeCleanScript();
            return ResponseEntity.ok("Clean script executed successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to execute data script: " + e.getMessage());
        }
    }
}
