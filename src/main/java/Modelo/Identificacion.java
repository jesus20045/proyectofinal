package Modelo;

public class Identificacion {
    private int idIdentificacion;
    private String codigo;
    private String correo;
    private String fechaCreacion;

    public Identificacion(int idIdentificacion, String codigo, String correo, String fechaCreacion) {
        this.idIdentificacion = idIdentificacion;
        this.codigo = codigo;
        this.correo = correo;
        this.fechaCreacion = fechaCreacion;
    }

    public Identificacion() {
    }

    // Getters y Setters
    public int getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(int idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}