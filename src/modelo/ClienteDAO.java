package modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;
public class ClienteDAO {
    //Atributos
    Conexion con = new Conexion();
    Connection connection;
    static String consultaSQL;
    static PreparedStatement statement;
    static ResultSet resultado;
            
    //Métodos
    public List Listar(){
        List<Cliente> lista = new ArrayList<>();
        consultaSQL = "SELECT * FROM cliente WHERE estado = 1";
        try{
            connection = con.coneccion();
            statement = connection.prepareStatement(consultaSQL);
            resultado = statement.executeQuery(consultaSQL);
            
            while(resultado.next()){
                Cliente c = new Cliente();
                c.setIdCliente(resultado.getInt(1));
                c.setNombres(resultado.getString(2));
                c.setApellidos(resultado.getString(3));
                c.setDocumentoIdentidad(resultado.getString(4));
                c.setDireccion(resultado.getString(5));
                c.setCorreo(resultado.getString(6));
                c.setCelular(resultado.getInt(7));
                
                lista.add(c);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return lista;
    }
    
}
