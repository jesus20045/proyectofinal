package controlador;

import Coneccion.CConeccion;
import Modelo.Identificacion;
import java.util.List;

public class ControladorIdentificacion {
    
    private CConeccion conexion;

    public ControladorIdentificacion() {
        this.conexion = new CConeccion(); // Inicializar la conexión
    }
    
    
     public int agregarIdentificacion(String codigo){
         return conexion.agregarIdentificacion(codigo);
     }
    
     public List<Identificacion> obtenerIdentificacion(){
         return conexion.obtenerIdentificacion();
     }
     
   public boolean eliminarIdentificacion(String codigo){
       return conexion.eliminarIdentificacion(codigo);
   }
     
}
