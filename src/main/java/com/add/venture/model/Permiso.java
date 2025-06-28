package com.add.venture.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permiso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    @EqualsAndHashCode.Include
    private Long idPermiso;

    @Column(name = "nombre_permiso", length = 100, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String nombrePermiso;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "categoria", length = 50)
    private String categoria; // GRUPO, CHAT, USUARIOS, SISTEMA

    @Column(name = "estado", length = 20)
    @Builder.Default
    private String estado = "activo";

    @Column(name = "fecha_creacion")
    @Builder.Default
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // Enum para permisos predefinidos del sistema
    public enum PermisosSistema {
        // Permisos de GRUPO
        CREAR_GRUPO("CREAR_GRUPO", "Crear grupos de viaje", "GRUPO"),
        EDITAR_GRUPO("EDITAR_GRUPO", "Editar información del grupo", "GRUPO"),
        ELIMINAR_GRUPO("ELIMINAR_GRUPO", "Eliminar grupo completo", "GRUPO"),
        CERRAR_GRUPO("CERRAR_GRUPO", "Cerrar grupo (no permitir más miembros)", "GRUPO"),
        
        // Permisos de MIEMBROS
        INVITAR_MIEMBROS("INVITAR_MIEMBROS", "Invitar nuevos miembros", "MIEMBROS"),
        EXPULSAR_MIEMBROS("EXPULSAR_MIEMBROS", "Expulsar miembros del grupo", "MIEMBROS"),
        APROBAR_SOLICITUDES("APROBAR_SOLICITUDES", "Aprobar/rechazar solicitudes de unión", "MIEMBROS"),
        ASIGNAR_ROLES("ASIGNAR_ROLES", "Asignar roles a otros miembros", "MIEMBROS"),
        VER_LISTA_MIEMBROS("VER_LISTA_MIEMBROS", "Ver lista completa de miembros", "MIEMBROS"),
        
        // Permisos de CHAT
        ACCEDER_CHAT("ACCEDER_CHAT", "Acceder al chat del grupo", "CHAT"),
        ENVIAR_MENSAJES("ENVIAR_MENSAJES", "Enviar mensajes al chat", "CHAT"),
        ELIMINAR_MENSAJES("ELIMINAR_MENSAJES", "Eliminar mensajes del chat", "CHAT"),
        COMPARTIR_ARCHIVOS("COMPARTIR_ARCHIVOS", "Compartir archivos en el chat", "CHAT"),
        
        // Permisos de ITINERARIO
        EDITAR_ITINERARIO("EDITAR_ITINERARIO", "Editar itinerario del viaje", "ITINERARIO"),
        VER_ITINERARIO("VER_ITINERARIO", "Ver itinerario del viaje", "ITINERARIO"),
        
        // Permisos de SISTEMA
        ADMINISTRAR_SISTEMA("ADMINISTRAR_SISTEMA", "Administración completa del sistema", "SISTEMA"),
        VER_ESTADISTICAS("VER_ESTADISTICAS", "Ver estadísticas del grupo", "SISTEMA");

        private final String nombre;
        private final String descripcion;
        private final String categoria;

        PermisosSistema(String nombre, String descripcion, String categoria) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.categoria = categoria;
        }

        public String getNombre() { return nombre; }
        public String getDescripcion() { return descripcion; }
        public String getCategoria() { return categoria; }
    }
} 