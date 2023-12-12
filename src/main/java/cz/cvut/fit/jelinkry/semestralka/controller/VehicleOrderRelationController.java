package cz.cvut.fit.jelinkry.semestralka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.service.VehicleOrderRelationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class VehicleOrderRelationController {

    private final VehicleOrderRelationService vehicleOrderRelationService;
    
    VehicleOrderRelationController(VehicleOrderRelationService vehService){
        vehicleOrderRelationService = vehService;
    }

    @PostMapping("/vehicle/order/{vehicleId}/{orderId}")
    public ResponseEntity<String> createVehicleOrderRelation(@PathVariable Long vehicleId, @PathVariable Long orderId){
        try{
            vehicleOrderRelationService.AddVehicleToOrder(vehicleId, orderId);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no order or vehicle with this id");
        }

        return ResponseEntity.ok().body("Order with id" + orderId + " was added to vehicle with id "+ vehicleId);
    }

    @DeleteMapping("/vehicle/order/{vehicleId}/{orderId}")
    public ResponseEntity<String> removeVehicleOrderRelation(@PathVariable Long vehicleId, @PathVariable Long orderId){
        try{
            vehicleOrderRelationService.RemoveVehicleFromOrder(vehicleId, orderId);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no order or vehicle with this id");
        }

        return ResponseEntity.ok().body("Vehicle with id" + vehicleId + " was removed from order with id "+ orderId);
    }
}
