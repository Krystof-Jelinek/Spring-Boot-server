package cz.cvut.fit.jelinkry.semestralka.controller;

import org.springframework.stereotype.Controller;

import cz.cvut.fit.jelinkry.semestralka.domain.Vehicle;
import cz.cvut.fit.jelinkry.semestralka.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VehicleController {
    private final VehicleService vehicleService;

    VehicleController(VehicleService vehService){
        vehicleService = vehService;
    }

    @GetMapping("/newveh")
    public String createData() {
        vehicleService.create(new Vehicle(1L, "AAAA", "green", 1));
        return "proc to nejdeeee";
    }

    @GetMapping("/vehicle")
    public Iterable<Vehicle> getAllOrders(){
        return vehicleService.readAll();
    }
    
}
