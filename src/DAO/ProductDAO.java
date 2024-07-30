
package DAO;

import DTO.ProductDTO;  
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class ProductDAO {
     Connection conn;
     PreparedStatement pstm;
     ResultSet rs;
     ArrayList<ProductDTO> ProductList= new ArrayList<>();
    public void AddProductToDB(ProductDTO ObjProductDTO){
       String sql ="insert into products(NAME_Product,QTD_Product,PRICE_Product) values (?,?,?)";
       
       conn= new ConnectionDAO().connectionDB();
        try {
            pstm=conn.prepareStatement(sql);
            pstm.setString(1, ObjProductDTO.getProductName());
            pstm.setInt(2,ObjProductDTO.getQTDProduct());
            pstm.setDouble(3,ObjProductDTO.getProductPrice());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"AddProductToDB: " + e);
        }
    }
    public ArrayList<ProductDTO> SearchProducts(){
        String sql="select * from products";
        conn = new ConnectionDAO().connectionDB();
        try {
            pstm=conn.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){
                ProductDTO ObjProductDTO = new ProductDTO();
                ObjProductDTO.setProduct_ID(rs.getInt("ID_Product"));
                ObjProductDTO.setProductName(rs.getString("NAME_Product"));
                ObjProductDTO.setProductPrice(rs.getDouble("PRICE_Product"));
                ObjProductDTO.setQTDProduct(rs.getInt("QTD_Product"));
                
                ProductList.add(ObjProductDTO);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"SearchProduct: " +e);
        }
        return ProductList;
    }
    public void UpdateProductFromDB(ProductDTO ObjProductDTO){
        String sql = "update products set NAME_Product=?,QTD_Product=?,PRICE_Product=? where ID_Product=?";
        
        conn= new ConnectionDAO().connectionDB();
        try{
            pstm=conn.prepareStatement(sql);
            pstm.setString(1,ObjProductDTO.getProductName());
            pstm.setInt(2, ObjProductDTO.getQTDProduct());
            pstm.setDouble(3, ObjProductDTO.getProductPrice());
            pstm.setDouble(4,ObjProductDTO.getProduct_ID());
            
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"UpdateProductfromDB: "+e);
        }
            
    }
}
