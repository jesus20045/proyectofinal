
package Modelo;

import java.util.Date;

public class CarreraProfesional {
    private int idCarreraProfesional;
    private String facultad;
    private String carrera;
    private Date fechaIngreso;

    // Constructor
    public CarreraProfesional(int idCarreraProfesional, String facultad, String carrera, Date fechaIngreso) {
        this.idCarreraProfesional = idCarreraProfesional;
        this.facultad = facultad;
        this.carrera = carrera;
        this.fechaIngreso = fechaIngreso;
    }

    public CarreraProfesional() {
    }

    // Getters y Setters
    public int getIdCarreraProfesional() {
        return idCarreraProfesional;
    }

    public void setIdCarreraProfesional(int idCarreraProfesional) {
        this.idCarreraProfesional = idCarreraProfesional;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}

    

