/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emtities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AA
 */
@Entity
@Table(name = "thanhvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thanhvien.findAll", query = "SELECT t FROM Thanhvien t"),
    @NamedQuery(name = "Thanhvien.findByThanhVienID", query = "SELECT t FROM Thanhvien t WHERE t.thanhVienID = :thanhVienID"),
    @NamedQuery(name = "Thanhvien.findByHo", query = "SELECT t FROM Thanhvien t WHERE t.ho = :ho"),
    @NamedQuery(name = "Thanhvien.findByTen", query = "SELECT t FROM Thanhvien t WHERE t.ten = :ten"),
    @NamedQuery(name = "Thanhvien.findByNgaySinh", query = "SELECT t FROM Thanhvien t WHERE t.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Thanhvien.findByGioiTinh", query = "SELECT t FROM Thanhvien t WHERE t.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Thanhvien.findByDiaChi", query = "SELECT t FROM Thanhvien t WHERE t.diaChi = :diaChi"),
    @NamedQuery(name = "Thanhvien.findBySoDT1", query = "SELECT t FROM Thanhvien t WHERE t.soDT1 = :soDT1"),
    @NamedQuery(name = "Thanhvien.findBySoDT2", query = "SELECT t FROM Thanhvien t WHERE t.soDT2 = :soDT2"),
    @NamedQuery(name = "Thanhvien.findByEmail", query = "SELECT t FROM Thanhvien t WHERE t.email = :email"),
    @NamedQuery(name = "Thanhvien.findByChuyenMon", query = "SELECT t FROM Thanhvien t WHERE t.chuyenMon = :chuyenMon"),
    @NamedQuery(name = "Thanhvien.findByChucDanh", query = "SELECT t FROM Thanhvien t WHERE t.chucDanh = :chucDanh"),
    @NamedQuery(name = "Thanhvien.findByLoaiTV", query = "SELECT t FROM Thanhvien t WHERE t.loaiTV = :loaiTV"),
    @NamedQuery(name = "Thanhvien.findByGhiChu", query = "SELECT t FROM Thanhvien t WHERE t.ghiChu = :ghiChu")})
public class Thanhvien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "thanhVienID")
    private String thanhVienID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ten")
    private String ten;
    @Size(max = 10)
    @Column(name = "ngaySinh")
    private String ngaySinh;
    @Column(name = "gioiTinh")
    private Integer gioiTinh;
    @Size(max = 250)
    @Column(name = "diaChi")
    private String diaChi;
    @Size(max = 16)
    @Column(name = "soDT1")
    private String soDT1;
    @Size(max = 16)
    @Column(name = "soDT2")
    private String soDT2;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 50)
    @Column(name = "chuyenMon")
    private String chuyenMon;
    @Size(max = 50)
    @Column(name = "chucDanh")
    private String chucDanh;
    @Column(name = "loaiTV")
    private Integer loaiTV;
    @Size(max = 250)
    @Column(name = "ghiChu")
    private String ghiChu;
    @OneToMany(mappedBy = "thanhVienID")
    private List<Taikhoan> taikhoanList;

    public Thanhvien() {
    }

    public Thanhvien(String thanhVienID) {
        this.thanhVienID = thanhVienID;
    }

    public Thanhvien(String thanhVienID, String ho, String ten) {
        this.thanhVienID = thanhVienID;
        this.ho = ho;
        this.ten = ten;
    }

    public String getThanhVienID() {
        return thanhVienID;
    }

    public void setThanhVienID(String thanhVienID) {
        this.thanhVienID = thanhVienID;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT1() {
        return soDT1;
    }

    public void setSoDT1(String soDT1) {
        this.soDT1 = soDT1;
    }

    public String getSoDT2() {
        return soDT2;
    }

    public void setSoDT2(String soDT2) {
        this.soDT2 = soDT2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public Integer getLoaiTV() {
        return loaiTV;
    }

    public void setLoaiTV(Integer loaiTV) {
        this.loaiTV = loaiTV;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @XmlTransient
    public List<Taikhoan> getTaikhoanList() {
        return taikhoanList;
    }

    public void setTaikhoanList(List<Taikhoan> taikhoanList) {
        this.taikhoanList = taikhoanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (thanhVienID != null ? thanhVienID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thanhvien)) {
            return false;
        }
        Thanhvien other = (Thanhvien) object;
        if ((this.thanhVienID == null && other.thanhVienID != null) || (this.thanhVienID != null && !this.thanhVienID.equals(other.thanhVienID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtities.Thanhvien[ thanhVienID=" + thanhVienID + " ]";
    }
    
}
