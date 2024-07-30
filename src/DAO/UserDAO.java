package DAO;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UserDAO {

    Connection conn;

    public ResultSet UserAuthentication(UserDTO UserObjDTO) {
        
        conn = new ConnectionDAO().connectionDB();
        try {
            String sql = "select * from users where UserName=? and password=?";
            
            PreparedStatement pstm = (PreparedStatement)conn.prepareStatement(sql);
            
            pstm.setString(1,UserObjDTO.getUserName());
            pstm.setString(2,UserObjDTO.getUser_Password());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UserDAO:  " + e);
            return null;
        }
    }
}
