package com.add.venture.dto;

import java.util.List;

/**
 * DTO para la respuesta del perfil de usuario en la API REST
 */
public class PerfilResponseDTO {
    private Long idUsuario;
    private String nombre;
    private String apellidos;
    private String username;
    private String email;
    private String telefono;
    private String ciudad;
    private String pais;
    private Integer edad;
    private String biografia;
    private String imagenPerfil;
    private String imagenPortada;
    private String fechaRegistroFormateada;
    private String iniciales;
    private boolean esPerfilPropio;
    
    // Estadísticas
    private long viajesCompletados;
    private long totalResenas;
    private String promedioCalificaciones;
    private long totalLogros;
    private boolean verificado;
    
    // Listas
    private List<ResenaDTO> resenasRecientes;
    private List<LogroDTO> logros;
    private List<ViajePerfilDTO> proximosViajes;
    private List<ViajePerfilDTO> historialViajes;
    private int totalProximosViajes;
    private int totalHistorialViajes;

    // Constructor vacío
    public PerfilResponseDTO() {
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public String getFechaRegistroFormateada() {
        return fechaRegistroFormateada;
    }

    public void setFechaRegistroFormateada(String fechaRegistroFormateada) {
        this.fechaRegistroFormateada = fechaRegistroFormateada;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    public boolean isEsPerfilPropio() {
        return esPerfilPropio;
    }

    public void setEsPerfilPropio(boolean esPerfilPropio) {
        this.esPerfilPropio = esPerfilPropio;
    }

    public long getViajesCompletados() {
        return viajesCompletados;
    }

    public void setViajesCompletados(long viajesCompletados) {
        this.viajesCompletados = viajesCompletados;
    }

    public long getTotalResenas() {
        return totalResenas;
    }

    public void setTotalResenas(long totalResenas) {
        this.totalResenas = totalResenas;
    }

    public String getPromedioCalificaciones() {
        return promedioCalificaciones;
    }

    public void setPromedioCalificaciones(String promedioCalificaciones) {
        this.promedioCalificaciones = promedioCalificaciones;
    }

    public long getTotalLogros() {
        return totalLogros;
    }

    public void setTotalLogros(long totalLogros) {
        this.totalLogros = totalLogros;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public List<ResenaDTO> getResenasRecientes() {
        return resenasRecientes;
    }

    public void setResenasRecientes(List<ResenaDTO> resenasRecientes) {
        this.resenasRecientes = resenasRecientes;
    }

    public List<LogroDTO> getLogros() {
        return logros;
    }

    public void setLogros(List<LogroDTO> logros) {
        this.logros = logros;
    }

    public List<ViajePerfilDTO> getProximosViajes() {
        return proximosViajes;
    }

    public void setProximosViajes(List<ViajePerfilDTO> proximosViajes) {
        this.proximosViajes = proximosViajes;
    }

    public List<ViajePerfilDTO> getHistorialViajes() {
        return historialViajes;
    }

    public void setHistorialViajes(List<ViajePerfilDTO> historialViajes) {
        this.historialViajes = historialViajes;
    }

    public int getTotalProximosViajes() {
        return totalProximosViajes;
    }

    public void setTotalProximosViajes(int totalProximosViajes) {
        this.totalProximosViajes = totalProximosViajes;
    }

    public int getTotalHistorialViajes() {
        return totalHistorialViajes;
    }

    public void setTotalHistorialViajes(int totalHistorialViajes) {
        this.totalHistorialViajes = totalHistorialViajes;
    }

    // Clases internas para sub-objetos
    public static class ResenaDTO {
        private Long idResena;
        private String comentario;
        private int calificacion;
        private String fecha;
        private AutorResenaDTO autor;
        private GrupoSimpleDTO grupo;

        public ResenaDTO() {
        }

        public Long getIdResena() {
            return idResena;
        }

        public void setIdResena(Long idResena) {
            this.idResena = idResena;
        }

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }

        public int getCalificacion() {
            return calificacion;
        }

        public void setCalificacion(int calificacion) {
            this.calificacion = calificacion;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public AutorResenaDTO getAutor() {
            return autor;
        }

        public void setAutor(AutorResenaDTO autor) {
            this.autor = autor;
        }

        public GrupoSimpleDTO getGrupo() {
            return grupo;
        }

        public void setGrupo(GrupoSimpleDTO grupo) {
            this.grupo = grupo;
        }
    }

    public static class AutorResenaDTO {
        private Long idUsuario;
        private String nombre;
        private String apellidos;
        private String fotoPerfil;
        private String iniciales;

        public AutorResenaDTO() {
        }

        public Long getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getFotoPerfil() {
            return fotoPerfil;
        }

        public void setFotoPerfil(String fotoPerfil) {
            this.fotoPerfil = fotoPerfil;
        }

        public String getIniciales() {
            return iniciales;
        }

        public void setIniciales(String iniciales) {
            this.iniciales = iniciales;
        }
    }

    public static class GrupoSimpleDTO {
        private Long idGrupo;
        private String nombreViaje;

        public GrupoSimpleDTO() {
        }

        public Long getIdGrupo() {
            return idGrupo;
        }

        public void setIdGrupo(Long idGrupo) {
            this.idGrupo = idGrupo;
        }

        public String getNombreViaje() {
            return nombreViaje;
        }

        public void setNombreViaje(String nombreViaje) {
            this.nombreViaje = nombreViaje;
        }
    }

    public static class LogroDTO {
        private Long idLogro;
        private String nombre;
        private String descripcion;
        private String icono;
        private String fechaOtorgado;

        public LogroDTO() {
        }

        public Long getIdLogro() {
            return idLogro;
        }

        public void setIdLogro(Long idLogro) {
            this.idLogro = idLogro;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getIcono() {
            return icono;
        }

        public void setIcono(String icono) {
            this.icono = icono;
        }

        public String getFechaOtorgado() {
            return fechaOtorgado;
        }

        public void setFechaOtorgado(String fechaOtorgado) {
            this.fechaOtorgado = fechaOtorgado;
        }
    }

    public static class ViajePerfilDTO {
        private Long idGrupo;
        private String nombreViaje;
        private String estado;
        private String destinoPrincipal;
        private String imagenDestacada;
        private String fechaInicio;
        private String fechaFin;

        public ViajePerfilDTO() {
        }

        public Long getIdGrupo() {
            return idGrupo;
        }

        public void setIdGrupo(Long idGrupo) {
            this.idGrupo = idGrupo;
        }

        public String getNombreViaje() {
            return nombreViaje;
        }

        public void setNombreViaje(String nombreViaje) {
            this.nombreViaje = nombreViaje;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getDestinoPrincipal() {
            return destinoPrincipal;
        }

        public void setDestinoPrincipal(String destinoPrincipal) {
            this.destinoPrincipal = destinoPrincipal;
        }

        public String getImagenDestacada() {
            return imagenDestacada;
        }

        public void setImagenDestacada(String imagenDestacada) {
            this.imagenDestacada = imagenDestacada;
        }

        public String getFechaInicio() {
            return fechaInicio;
        }

        public void setFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
        }

        public String getFechaFin() {
            return fechaFin;
        }

        public void setFechaFin(String fechaFin) {
            this.fechaFin = fechaFin;
        }
    }
}
