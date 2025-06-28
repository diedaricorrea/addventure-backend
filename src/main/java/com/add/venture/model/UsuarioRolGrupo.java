package com.add.venture.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario_rol_grupo", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_grupo"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioRolGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_rol_grupo")
    @EqualsAndHashCode.Include
    private Long idUsuarioRolGrupo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({"gruposCreados", "etiquetas", "logros", "contrasenaHash"})
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    @JsonIgnoreProperties({"permisos"})
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_grupo", nullable = false)
    @JsonIgnoreProperties({"creador", "viaje", "etiquetas", "itinerarios", "participantes", "mensajes", "resenas"})
    private GrupoViaje grupo;

    @Column(name = "fecha_asignacion")
    @Builder.Default
    private LocalDateTime fechaAsignacion = LocalDateTime.now();

    @Column(name = "asignado_por")
    private Long asignadoPor; // ID del usuario que asignó este rol

    @Column(name = "estado", length = 20)
    @Builder.Default
    private String estado = "activo";

    @Column(name = "notas")
    private String notas; // Notas adicionales sobre la asignación del rol
} 