package com.add.venture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.add.venture.model.GrupoViaje;
import com.add.venture.model.Itinerario;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Integer> {
    
    /**
     * Busca todos los itinerarios de un grupo ordenados por día
     * 
     * @param grupo el grupo de viaje
     * @return lista de itinerarios ordenados por día
     */
    List<Itinerario> findByGrupoOrderByDiaNumeroAsc(GrupoViaje grupo);
    
    /**
     * Elimina todos los itinerarios de un grupo
     * 
     * @param grupo el grupo de viaje
     */
    @Modifying
    @Transactional
    @Query("DELETE FROM Itinerario i WHERE i.grupo = :grupo")
    void deleteByGrupo(@Param("grupo") GrupoViaje grupo);
    
    /**
     * Cuenta los itinerarios de un grupo
     * 
     * @param grupo el grupo de viaje
     * @return número de itinerarios
     */
    long countByGrupo(GrupoViaje grupo);
} 