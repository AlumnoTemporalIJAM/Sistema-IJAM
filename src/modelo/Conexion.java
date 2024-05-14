package modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {    
    //Atributo
    private String url = "jdbc:mysql://localhost:3306/DBIJAM";
    private String user = "nsalvadorl";
    private String password = "12345678";
    private Connection connection = null;
    
    //Métodos (funciones y procedimientos)
    public Connection coneccion(){    
        try{
        //Conexion
            connection = DriverManager.getConnection(url, user, password);
        }catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
        return connection;
    }

}
