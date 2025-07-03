package com.add.venture.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.add.venture.model.GrupoViaje;
import com.add.venture.model.Rol;
import com.add.venture.model.Usuario;
import com.add.venture.model.UsuarioRolGrupo;

@Repository
public interface UsuarioRolGrupoRepository extends JpaRepository<UsuarioRolGrupo, Long> {
    
    Optional<UsuarioRolGrupo> findByUsuarioAndGrupo(Usuario usuario, GrupoViaje grupo);
    
    List<UsuarioRolGrupo> findByUsuario(Usuario usuario);
    
    List<UsuarioRolGrupo> findByGrupo(GrupoViaje grupo);
    
    List<UsuarioRolGrupo> findByRol(Rol rol);
    
    List<UsuarioRolGrupo> findByUsuarioAndEstado(Usuario usuario, String estado);
    
    List<UsuarioRolGrupo> findByGrupoAndEstado(GrupoViaje grupo, String estado);
    
    @Query("SELECT urg FROM UsuarioRolGrupo urg WHERE urg.usuario = :usuario AND urg.grupo = :grupo AND urg.estado = 'activo'")
    Optional<UsuarioRolGrupo> findActiveByUsuarioAndGrupo(@Param("usuario") Usuario usuario, @Param("grupo") GrupoViaje grupo);
    
    @Query("SELECT urg FROM UsuarioRolGrupo urg WHERE urg.grupo = :grupo AND urg.estado = 'activo'")
    List<UsuarioRolGrupo> findActiveByGrupo(@Param("grupo") GrupoViaje grupo);
    
    @Query("SELECT urg FROM UsuarioRolGrupo urg WHERE urg.usuario = :usuario AND urg.estado = 'activo'")
    List<UsuarioRolGrupo> findActiveByUsuario(@Param("usuario") Usuario usuario);
} 