package Modelo;

public class Alumnos {
    private int idAlumno;
    private int idCarreraProfesional;
    private int idIdentificacion;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dni;

    public Alumnos(int idAlumno, int idCarreraProfesional, int idIdentificacion, String nombres, String apellidoPaterno, String apellidoMaterno, String dni) {
        this.idAlumno = idAlumno;
        this.idCarreraProfesional = idCarreraProfesional;
        this.idIdentificacion = idIdentificacion;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.dni = dni;
    }

    public Alumnos() {
    }

    // Getters y Setters
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCarreraProfesional() {
        return idCarreraProfesional;
    }

    public void setIdCarreraProfesional(int idCarreraProfesional) {
        this.idCarreraProfesional = idCarreraProfesional;
    }

    public int getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(int idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}