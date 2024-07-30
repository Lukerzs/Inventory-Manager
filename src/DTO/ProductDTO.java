/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;


public class ProductDTO {
    private String ProductName;
    private int QTDProduct;
    private Double ProductPrice;
    private int Product_ID;

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    public int getQTDProduct() {
        return QTDProduct;
    }

    public void setQTDProduct(int QTDProduct) {
        this.QTDProduct = QTDProduct;
    }

    public Double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(Double ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int Product_ID) {
        this.Product_ID = Product_ID;
    }
    

}
