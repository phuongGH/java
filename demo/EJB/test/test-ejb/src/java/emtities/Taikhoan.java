/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package emtities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AA
 */
@Entity
@Table(name = "taikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taikhoan.findAll", query = "SELECT t FROM Taikhoan t"),
    @NamedQuery(name = "Taikhoan.findByUserName", query = "SELECT t FROM Taikhoan t WHERE t.userName = :userName"),
    @NamedQuery(name = "Taikhoan.findByPassword", query = "SELECT t FROM Taikhoan t WHERE t.password = :password"),
    @NamedQuery(name = "Taikhoan.findByNgayTao", query = "SELECT t FROM Taikhoan t WHERE t.ngayTao = :ngayTao"),
    @NamedQuery(name = "Taikhoan.findByGhiChu", query = "SELECT t FROM Taikhoan t WHERE t.ghiChu = :ghiChu")})
public class Taikhoan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Column(name = "ngayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    @Size(max = 250)
    @Column(name = "ghiChu")
    private String ghiChu;
    @JoinColumn(name = "thanhVienID", referencedColumnName = "thanhVienID")
    @ManyToOne
    private Thanhvien thanhVienID;
    @JoinColumn(name = "idNhom", referencedColumnName = "idNhom")
    @ManyToOne
    private Nhomtk idNhom;

    public Taikhoan() {
    }

    public Taikhoan(String userName) {
        this.userName = userName;
    }

    public Taikhoan(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Thanhvien getThanhVienID() {
        return thanhVienID;
    }

    public void setThanhVienID(Thanhvien thanhVienID) {
        this.thanhVienID = thanhVienID;
    }

    public Nhomtk getIdNhom() {
        return idNhom;
    }

    public void setIdNhom(Nhomtk idNhom) {
        this.idNhom = idNhom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taikhoan)) {
            return false;
        }
        Taikhoan other = (Taikhoan) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtities.Taikhoan[ userName=" + userName + " ]";
    }
    
}
