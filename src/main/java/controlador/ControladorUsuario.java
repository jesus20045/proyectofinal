package controlador;

import Coneccion.CConeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorUsuario {
    private CConeccion conexion;

    public ControladorUsuario() {
        this.conexion = new CConeccion(); // Inicializar la conexión
    }

    public boolean autenticar(String usuario, String contrasenia) {
        String query = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";
        try (Connection conn = conexion.establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contrasenia);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Si hay un resultado, las credenciales son válidas
        } catch (SQLException e) {
            System.err.println("Error al verificar las credenciales: " + e.getMessage());
            return false;
        }
    }
}

     


