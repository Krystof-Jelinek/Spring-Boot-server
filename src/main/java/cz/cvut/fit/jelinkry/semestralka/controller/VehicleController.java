package cz.cvut.fit.jelinkry.semestralka.controller;

import cz.cvut.fit.jelinkry.semestralka.domain.Vehicle;
import cz.cvut.fit.jelinkry.semestralka.domain.VehicleDTO;
import cz.cvut.fit.jelinkry.semestralka.service.VehicleService;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class VehicleController {
    private final VehicleService vehicleService;

    VehicleController(VehicleService vehService){
        vehicleService = vehService;
    }

    @PostMapping("/vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO data){
        Vehicle tmp = new Vehicle(data.getSpz(), data.getColor(), data.getEquipmentLevel());
        try{
            vehicleService.create(tmp);
        }
        catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id){
        Optional<Vehicle> tmp = vehicleService.readById(id);
        if(tmp.isPresent()){
            return ResponseEntity.ok(tmp.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/vehicle")
    public Iterable<Vehicle> getAllVehicle(){
        return vehicleService.readAll();
    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<String> modifyVehicle(@PathVariable Long id, @RequestBody VehicleDTO data) {
        if(!vehicleService.readById(id).isPresent()){
            return ResponseEntity.badRequest().body("There is no vehicle with this id: " + id);
        }
        try{
            vehicleService.updateOnlyVehicleRelated(id, data);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("vehicle got modified succesfully");
    }

    @DeleteMapping("vehicle/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id){
        try{
            vehicleService.deleteById(id);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no vehicle with this id: " + id);
        }
        return ResponseEntity.ok("vehicle with id: " + id + " deleted succesfully");
    }
    
}
