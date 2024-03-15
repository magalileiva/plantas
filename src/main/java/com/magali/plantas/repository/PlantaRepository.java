package com.magali.plantas.repository;

import com.magali.plantas.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
    List<Planta> findByNameContainingIgnoreCase (String name);
    List<Planta> findByEstadoSalud(String estadoSalud);

}
