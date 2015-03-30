package entities;
// Generated Jul 6, 2014 3:40:13 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Taikhoan generated by hbm2java
 */
public class Taikhoan  implements java.io.Serializable {


     private String username;
     private String password;
     private String hoten;
     private String email;
     private BigDecimal dienthoai;
     private String congty;
     private String diachi;
     private Set hoadons = new HashSet(0);

    public Taikhoan() {
    }

	
    public Taikhoan(String username) {
        this.username = username;
    }
    public Taikhoan(String username, String password, String hoten, String email, BigDecimal dienthoai, String congty, String diachi, Set hoadons) {
       this.username = username;
       this.password = password;
       this.hoten = hoten;
       this.email = email;
       this.dienthoai = dienthoai;
       this.congty = congty;
       this.diachi = diachi;
       this.hoadons = hoadons;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getHoten() {
        return this.hoten;
    }
    
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public BigDecimal getDienthoai() {
        return this.dienthoai;
    }
    
    public void setDienthoai(BigDecimal dienthoai) {
        this.dienthoai = dienthoai;
    }
    public String getCongty() {
        return this.congty;
    }
    
    public void setCongty(String congty) {
        this.congty = congty;
    }
    public String getDiachi() {
        return this.diachi;
    }
    
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public Set getHoadons() {
        return this.hoadons;
    }
    
    public void setHoadons(Set hoadons) {
        this.hoadons = hoadons;
    }




}


