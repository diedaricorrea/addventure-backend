package com.add.venture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.add.venture.model.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    
    Optional<Permiso> findByNombrePermiso(String nombrePermiso);
    
    List<Permiso> findByCategoria(String categoria);
    
    List<Permiso> findByEstado(String estado);
    
    @Query("SELECT p FROM Permiso p WHERE p.nombrePermiso IN :nombres AND p.estado = 'activo'")
    List<Permiso> findByNombresPermiso(@Param("nombres") List<String> nombres);
    
    @Query("SELECT p FROM Permiso p WHERE p.categoria IN :categorias AND p.estado = 'activo'")
    List<Permiso> findByCategorias(@Param("categorias") List<String> categorias);
} 