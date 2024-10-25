
package Coneccion;

import Modelo.Alumnos;
import Modelo.CarreraProfesional;
import Modelo.Identificacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CConeccion {
    private String url = "jdbc:sqlserver://escuelaupla.database.windows.net;databaseName=escuelaDB";
    private String usuario = "joelsoriano"; 
    private String contraseña = "santiaguito2020?"; 

    public Connection establecerConexion() throws SQLException {
        return DriverManager.getConnection(url, usuario, contraseña);
    }

    public boolean autenticar(String usuario, String contraseña) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";
        
        // Utilizar un bloque try-with-resources para asegurar el cierre de recursos
        try (PreparedStatement statement = establecerConexion().prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            statement.setString(1, usuario);
            statement.setString(2, contraseña);
            
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Devuelve true si el usuario existe
            return resultSet.next(); 
        } catch (SQLException e) {
            // Manejo de excepciones
            System.err.println("Error al autenticar al usuario: " + e.getMessage());
            return false;
        }
    }
    
    public int agregarIdentificacion(String codigo) {
        String sql = "INSERT INTO Identificacion (codigo, correo, fechacreacion) VALUES (?, ?, ?);";

        try (Connection conexion = establecerConexion(); 
             PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"));
            java.util.Date fechaActual = calendar.getTime();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(fechaActual.getTime());
            
            String correo = codigo+"@gmail.com";
            
            pstmt.setString(1, codigo);
            pstmt.setString(2, correo);
            pstmt.setTimestamp(3, timestamp);


            int filasAfectadas = pstmt.executeUpdate(); // Cuántas filas fueron afectadas, debe ser 1
            if (filasAfectadas > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Puedes mejorar este manejo de errores
        }

        return 0; 
    }
    
    public int agregarCarreraProfesional(String facultad, String carrera) {
        String sql = "INSERT INTO Carrera_profesional (facultad, carrera, fechaingreso) VALUES (?, ?, ?);";

        try (Connection conexion = establecerConexion(); 
             PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"));
            java.util.Date fechaActual = calendar.getTime();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(fechaActual.getTime());
            pstmt.setString(1, facultad);
            pstmt.setString(2, carrera);
            pstmt.setTimestamp(3, timestamp);


            int filasAfectadas = pstmt.executeUpdate(); // Cuántas filas fueron afectadas, debe ser 1
            if (filasAfectadas > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Puedes mejorar este manejo de errores
        }

        return 0; 
    }
    
    public boolean agregarAlumno(int id_carreraprofesional, int id_identificacion, String nombre, String paterno, String materno, String dni  ) {
        String query = "INSERT INTO Alumnos (id_carreraprofesional, id_identificacion, nombres, apellido_paterno, apellido_materno , dni) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = establecerConexion();
            PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            
            pstmt.setInt(1, id_carreraprofesional);
            pstmt.setInt(2, id_identificacion);
            pstmt.setString(3,nombre );
            pstmt.setString(4, paterno);
            pstmt.setString(5, materno);
            pstmt.setString(6, dni );
            int rowsAffected = pstmt.executeUpdate(); // Devuelve el número de filas afectadas

            if (rowsAffected > 0) {
                System.out.println("Matrícula agregada exitosamente.");
                return true; // Retorna true si se inserta correctamente
            } else {
                System.out.println("No se agregó ninguna matrícula.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Error al agregar matrícula: " + e.getMessage());
            return false; // Retorna false si ocurre una excepción
        }
    }
    
    public List<Alumnos> obtenerAlumno() {
        List<Alumnos> alumnos = new ArrayList<>();
        String sql = "SELECT nombres,apellido_paterno,apellido_materno,dni FROM Alumnos";

        try (Connection conexion = establecerConexion(); 
             PreparedStatement stmt = conexion.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Alumnos alumno = new Alumnos();
                alumno.setNombres(rs.getString("nombres"));
                alumno.setApellidoPaterno(rs.getString("apellido_paterno"));
                alumno.setApellidoMaterno(rs.getString("apellido_materno"));
                alumno.setDni(rs.getString("dni"));
                alumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
    
    public List<Identificacion> obtenerIdentificacion() {
        List<Identificacion> identificaciones = new ArrayList<>();
        String sql = "SELECT codigo,correo FROM Identificacion";

        try (Connection conexion = establecerConexion(); 
             PreparedStatement stmt = conexion.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Identificacion identificacion = new Identificacion();
                identificacion.setCodigo(rs.getString("codigo"));
                identificacion.setCorreo(rs.getString("correo"));
                identificaciones.add(identificacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return identificaciones;
    }
    
    public List<CarreraProfesional> obtenerCarreraProfesional() {
        List<CarreraProfesional> carreras = new ArrayList<>();
        String sql = "SELECT facultad,carrera,fechaingreso FROM Carrera_profesional";

        try (Connection conexion = establecerConexion(); 
             PreparedStatement stmt = conexion.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                CarreraProfesional carrera = new CarreraProfesional();
                carrera.setCarrera(rs.getString("facultad"));
                carrera.setFacultad(rs.getString("carrera"));
                carrera.setFechaIngreso(rs.getDate("fechaingreso"));
                carreras.add(carrera);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carreras;
    }
    
    public boolean eliminarIdentificacion(String codigo) {
    String sqlIdentificacion = "DELETE FROM Identificacion WHERE codigo = ?;";
    try (PreparedStatement stmtIdentificacion = establecerConexion().prepareStatement(sqlIdentificacion)) {
        stmtIdentificacion.setString(1, codigo);
        return stmtIdentificacion.executeUpdate() > 0;  // Retorna verdadero si se eliminó al menos un registro
    } catch (SQLException e) {
        e.printStackTrace();
        return false;  // Retorna falso si ocurre un error
    }
}

    public boolean eliminarCarrera(String codigo) {
        String sqlCarrera = "DELETE FROM Carrera_profesional WHERE id_carreraprofesional = (SELECT id_identificacion FROM Identificacion WHERE codigo = ?) ;";
        try (PreparedStatement stmtCarrera = establecerConexion().prepareStatement(sqlCarrera)) {
            stmtCarrera.setString(1, codigo);
            return stmtCarrera.executeUpdate() > 0;  // Retorna verdadero si se eliminó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna falso si ocurre un error
        }
    }

    public boolean eliminarAlumnos(String codigo) {
        String sqlAlumnos = "DELETE FROM Alumnos WHERE dni = (SELECT dni FROM Identificacion WHERE codigo = ?);";
        try (PreparedStatement stmtAlumnos = establecerConexion().prepareStatement(sqlAlumnos)) {
            stmtAlumnos.setString(1, codigo);
            return stmtAlumnos.executeUpdate() > 0;  // Retorna verdadero si se eliminó al menos un registro
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna falso si ocurre un error
        }
    }
    
    public Alumnos obtenerLosCamposAlumnosModificar(String dni){
        Alumnos alumnos = null;
        String sql = "Select nombres,apellido_paterno,apellido_materno,dni FROM Alumnos WHERE dni = ?";
        
        try (Connection conexion = establecerConexion(); 
         PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
        stmt.setString(1, dni);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            alumnos = new Alumnos();
            alumnos.setNombres(rs.getString("nombres"));
            alumnos.setApellidoPaterno(rs.getString("apellido_paterno"));
            alumnos.setApellidoMaterno(rs.getString("apellido_materno"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
    
    public CarreraProfesional obtenerLosCamposCarreraModificar(String dni){
        CarreraProfesional carrera = null;
        String sql = "Select facultad,carrera FROM Carrera_profesional WHERE id_carreraprofesional = (SELECT id_carreraprofesional FROM Alumnos WHERE dni = ? )";
        
        try (Connection conexion = establecerConexion(); 
         PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
        stmt.setString(1, dni);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            carrera = new CarreraProfesional();
            carrera.setFacultad(rs.getString("facultad"));
            carrera.setCarrera(rs.getString("carrera"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrera;
    }
    
    public boolean actualizarAlumno(int id_carreraprofesional, String nombre, String paterno, String materno) {
    String query = "UPDATE Alumnos SET nombres = ?, apellido_paterno = ?, apellido_materno = ?  WHERE id_carreraprofesional = ?";

    try (Connection connection = establecerConexion();
            PreparedStatement pstmt = connection.prepareStatement(query)) {

           pstmt.setString(1, nombre);
           pstmt.setString(2, paterno);
           pstmt.setString(3, materno);
           pstmt.setInt(4, id_carreraprofesional);

           int rowsAffected = pstmt.executeUpdate(); // Devuelve el número de filas afectadas
           if (rowsAffected > 0) {
               System.out.println("Alumno actualizado exitosamente.");
               return true; // Retorna true si se actualiza correctamente
           } else {
               System.out.println("No se actualizó el alumno.");
               return false;
           }

        } catch (SQLException e) {
            System.err.println("Error al actualizar alumno: " + e.getMessage());
            return false; // Retorna false si ocurre una excepción
        }
    }

    public int actualizarCarreraProfesional(String dni, String facultad, String carrera) {
    String sqlUpdate = "UPDATE Carrera_profesional SET facultad = ?, carrera = ? WHERE id_carreraprofesional = (SELECT id_carreraprofesional FROM Alumnos Where dni = ?)";
    String sqlSelect = "SELECT id_carreraprofesional FROM Carrera_profesional WHERE id_carreraprofesional = (SELECT id_carreraprofesional FROM Alumnos Where dni = ?)";
    int idCarreraProfesional = 0; // Inicializar el id_carreraprofesional

    try (Connection conexion = establecerConexion();
         PreparedStatement pstmtUpdate = conexion.prepareStatement(sqlUpdate);
         PreparedStatement pstmtSelect = conexion.prepareStatement(sqlSelect)) {

        // Actualizar carrera profesional
        pstmtUpdate.setString(1, facultad);
        pstmtUpdate.setString(2, carrera);
        pstmtUpdate.setString(3, dni);
        int filasAfectadas = pstmtUpdate.executeUpdate();

        // Verificar si se afectaron filas
        if (filasAfectadas > 0) {
            // Consultar el id_carreraprofesional
            pstmtSelect.setString(1, dni);
            ResultSet rs = pstmtSelect.executeQuery();
            if (rs.next()) {
                idCarreraProfesional = rs.getInt("id_carreraprofesional"); // Asignar el id
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Manejo de excepciones en caso de error SQL
    }

    return idCarreraProfesional; // Retornar el id_carreraprofesional
}
    
    
}


