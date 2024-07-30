package DAO;


import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    Connection conn;
    public Connection connectionDB(){
         
        try {
           
            String url="";
            conn= (Connection) DriverManager.getConnection(url);
            return conn;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"ConnectionDAO " + e.getMessage());
            return null;
        }
        
    }
            
}
