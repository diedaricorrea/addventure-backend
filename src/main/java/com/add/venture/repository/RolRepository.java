package com.add.venture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.add.venture.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    
    Optional<Rol> findByNombreRol(String nombreRol);
    
    List<Rol> findByEstado(String estado);
    
    List<Rol> findByEsRolSistema(Boolean esRolSistema);
    
    @Query("SELECT r FROM Rol r WHERE r.nivelJerarquia >= :nivel AND r.estado = 'activo'")
    List<Rol> findRolesConNivelMenorOIgual(@Param("nivel") Integer nivel);
    
    @Query("SELECT r FROM Rol r WHERE r.nombreRol IN :nombres AND r.estado = 'activo'")
    List<Rol> findByNombresRol(@Param("nombres") List<String> nombres);
} 