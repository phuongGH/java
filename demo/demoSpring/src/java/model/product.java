package model;

public class product {
    private String IDProduct;
    private String Name_Product;
    private double Price_Product;

    public product() {
    }

    public product(String IDProduct, String Name_Product, double Price_Product) {
        this.IDProduct = IDProduct;
        this.Name_Product = Name_Product;
        this.Price_Product = Price_Product;
    }

    public String getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(String IDProduct) {
        this.IDProduct = IDProduct;
    }

    public String getName_Product() {
        return Name_Product;
    }

    public void setName_Product(String Name_Product) {
        this.Name_Product = Name_Product;
    }

    public double getPrice_Product() {
        return Price_Product;
    }

    public void setPrice_Product(double Price_Product) {
        this.Price_Product = Price_Product;
    }

    
    
}
