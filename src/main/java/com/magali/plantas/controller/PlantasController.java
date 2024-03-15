package com.magali.plantas.controller;

import com.magali.plantas.model.Planta;
import com.magali.plantas.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/plantas")
public class PlantasController {
    private final PlantaService plantaService;
    @Autowired
    public PlantasController(PlantaService plantaService){this.plantaService = plantaService;}

    @GetMapping
    public ResponseEntity<List<Planta>> getAll(){
        List<Planta> boardGames = plantaService.getPlantas();
        return ResponseEntity.ok(boardGames);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Planta>> getPlantaById(@PathVariable Long id){
        Optional<Planta> plantas = plantaService.getPlantasById(id);
        return ResponseEntity.ok(plantas);
    }
    @GetMapping("/name")
    public ResponseEntity<List<Planta>> getPlantaByName(@RequestParam String name){
        List<Planta> plantas = plantaService.getPlantasByName(name);
        return ResponseEntity.ok(plantas);
    }
    @GetMapping("/salud")
    public ResponseEntity<List<Planta>> getPlantaBySalud(@RequestParam String salud){
        List<Planta> plantas = plantaService.getPlantasBySalud(salud);
        return ResponseEntity.ok(plantas);
    }
    @PostMapping
    public ResponseEntity<Planta> savePlanta(@RequestBody Planta boardGame){
        Planta newPlanta = plantaService.saveOrUpdate(boardGame);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newPlanta);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlantaById(@PathVariable Long id){
        plantaService.deletePlanta(id);
        return ResponseEntity.noContent().build();
    }
}
