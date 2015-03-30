package entities;
// Generated Jul 10, 2014 9:41:15 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hoadon generated by hbm2java
 */
public class Hoadon  implements java.io.Serializable {


     private int mahoadon;
     private Taikhoan taikhoan;
     private String tenhoadon;
     private Date ngaylap;
     private String tinhtrang;
     private String hinhthucthanhtoan;
     private Set chitiethoadons = new HashSet(0);

    public Hoadon() {
    }

	
    public Hoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }
    public Hoadon(int mahoadon, Taikhoan taikhoan, String tenhoadon, Date ngaylap, String tinhtrang, String hinhthucthanhtoan, Set chitiethoadons) {
       this.mahoadon = mahoadon;
       this.taikhoan = taikhoan;
       this.tenhoadon = tenhoadon;
       this.ngaylap = ngaylap;
       this.tinhtrang = tinhtrang;
       this.hinhthucthanhtoan = hinhthucthanhtoan;
       this.chitiethoadons = chitiethoadons;
    }
   
    public int getMahoadon() {
        return this.mahoadon;
    }
    
    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }
    public Taikhoan getTaikhoan() {
        return this.taikhoan;
    }
    
    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
    public String getTenhoadon() {
        return this.tenhoadon;
    }
    
    public void setTenhoadon(String tenhoadon) {
        this.tenhoadon = tenhoadon;
    }
    public Date getNgaylap() {
        return this.ngaylap;
    }
    
    public void setNgaylap(Date ngaylap) {
        this.ngaylap = ngaylap;
    }
    public String getTinhtrang() {
        return this.tinhtrang;
    }
    
    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    public String getHinhthucthanhtoan() {
        return this.hinhthucthanhtoan;
    }
    
    public void setHinhthucthanhtoan(String hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }
    public Set getChitiethoadons() {
        return this.chitiethoadons;
    }
    
    public void setChitiethoadons(Set chitiethoadons) {
        this.chitiethoadons = chitiethoadons;
    }




}


