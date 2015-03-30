package model;


public class SinhVien {
    String MaSV;
    String HoTen;
    String DiaChi;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen, String DiaChi) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}
