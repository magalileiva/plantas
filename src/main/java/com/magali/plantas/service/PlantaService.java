package com.magali.plantas.service;

import com.magali.plantas.model.Planta;
import com.magali.plantas.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantaService {
    @Autowired
    PlantaRepository plantaRepository;
    public List<Planta> getPlantas(){
        return plantaRepository.findAll();
    }
    public Optional<Planta> getPlantasById(Long id){
        return plantaRepository.findById(id);
    }
    public Planta saveOrUpdate(Planta planta){
        return plantaRepository.save(planta);
    }
    public void deletePlanta(Long id) { plantaRepository.deleteById(id); }
    public List<Planta> getPlantasByName(String name){
        return plantaRepository.findByNameContainingIgnoreCase(name);
    }
    public  List<Planta> getPlantasBySalud(String salud){
        return plantaRepository.findByEstadoSalud(salud);
    }
}
