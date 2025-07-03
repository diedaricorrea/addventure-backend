package com.add.venture.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    @EqualsAndHashCode.Include
    private Long idRol;

    @Column(name = "nombre_rol", length = 50, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String nombreRol;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "nivel_jerarquia")
    private Integer nivelJerarquia; // 1=ADMIN, 2=LIDER, 3=CO_LIDER, 4=MIEMBRO

    @Column(name = "es_rol_sistema", nullable = false)
    @Builder.Default
    private Boolean esRolSistema = false; // Roles del sistema que no se pueden eliminar

    @Column(name = "estado", length = 20)
    @Builder.Default
    private String estado = "activo";

    @Column(name = "fecha_creacion")
    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Relación con permisos
    @ManyToMany
    @JoinTable(
        name = "rol_permiso",
        joinColumns = @JoinColumn(name = "id_rol"),
        inverseJoinColumns = @JoinColumn(name = "id_permiso")
    )
    @JsonIgnore
    private Set<Permiso> permisos;

    // Enum para roles predefinidos del sistema
    public enum RolesSistema {
        ADMIN_SISTEMA("ADMIN_SISTEMA", "Administrador del Sistema", 1),
        LIDER_GRUPO("LIDER_GRUPO", "Líder de Grupo", 2),
        CO_LIDER("CO_LIDER", "Co-líder", 3),
        MIEMBRO("MIEMBRO", "Miembro", 4),
        MIEMBRO_PREMIUM("MIEMBRO_PREMIUM", "Miembro Premium", 4);

        private final String nombre;
        private final String descripcion;
        private final int nivel;

        RolesSistema(String nombre, String descripcion, int nivel) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.nivel = nivel;
        }

        public String getNombre() { return nombre; }
        public String getDescripcion() { return descripcion; }
        public int getNivel() { return nivel; }
    }
} 