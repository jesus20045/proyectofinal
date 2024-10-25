package controlador;

import Coneccion.CConeccion;
import Modelo.CarreraProfesional;
import java.util.List;

public class ControladorCarreraProfesional {
    private CConeccion conexion;

    public ControladorCarreraProfesional() {
        this.conexion = new CConeccion(); // Inicializar la conexión
    }
    
    
    public int agregarCarreraProfesional(String facultad, String carrera){
        return conexion.agregarCarreraProfesional(facultad, carrera);
    }
    
    public List<CarreraProfesional> obtenerCarreraProfesional(){
        return conexion.obtenerCarreraProfesional();
    }
    
    public boolean eliminarCarrera(String codigo){
        return conexion.eliminarCarrera(codigo);
    }
    
    public CarreraProfesional obtenerLosCamposCarreraModificar(String dni){
        return conexion.obtenerLosCamposCarreraModificar(dni);
    }
    public int actualizarCarreraProfesional(String dni, String facultad, String carrera){
        return conexion.actualizarCarreraProfesional(dni, facultad, carrera);
    }
    
}
