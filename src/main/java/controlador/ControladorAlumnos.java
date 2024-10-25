package controlador;

import Coneccion.CConeccion;
import Modelo.Alumnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ControladorAlumnos {
    private CConeccion conexion;

    public ControladorAlumnos() {
        this.conexion = new CConeccion(); // Inicializar la conexión
    }

    // Método para autenticar al usuario
    public boolean autenticar(String usuario, String contraseña){
        return conexion.autenticar(usuario, contraseña);
    }
    
    
    public boolean agregarAlumno(int id_carreraprofesional, int id_identificacion, String nombre, String paterno, String materno, String dni  ){
        return conexion.agregarAlumno(id_carreraprofesional, id_identificacion, nombre, paterno, materno, dni);
    }
    
    public List<Alumnos> obtenerAlumno(){
        return conexion.obtenerAlumno();
    }
    
   public boolean eliminarAlumnos(String codigo){
       return conexion.eliminarAlumnos(codigo);
    }
    
    public Alumnos obtenerLosCamposAlumnosModificar(String dni){
        return conexion.obtenerLosCamposAlumnosModificar(dni);
    }
   
     public boolean actualizarAlumno(int id_carreraprofesional, String nombre, String paterno, String materno){
         return conexion.actualizarAlumno(id_carreraprofesional, nombre, paterno, materno);
     }
    
}

