/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconexionjdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploConexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/prueba";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    try {
        conexion = DriverManager.getConnection(url, usuario, password);
        
        statement = conexion.createStatement();
        statement.executeUpdate("INSERT INTO USUARIOS_P (USERNAME,PASSWORD) VALUES('Pepe' ,'ACN14')");
        
        statement.executeUpdate("UPDATE USUARIOS_P SET PASSWORD = '123456' WHERE USERNAME = 'ABC'");
                
        rs = statement.executeQuery("SELECT * FROM USUARIOS_P");
        rs.next();
        do{
            System.out.println(rs.getInt("user_id")+ " : "+rs.getString("userName"));
        }while(rs.next());
        
        statement.executeUpdate("DELETE FROM USUARIOS_P WHERE USERNAME = 'Marta'");
    } catch (SQLException ex) {
        Logger.getLogger(EjemploConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }
        
    }
    
