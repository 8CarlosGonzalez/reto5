package reto5.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    private static final String UBICACION_bd = "ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
    String url = "jdbc:sqlite:"+UBICACION_bd;
    return DriverManager.getConnection(url);
    }
}
