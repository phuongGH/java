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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AA
 */
@Entity
@Table(name = "nhomtk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhomtk.findAll", query = "SELECT n FROM Nhomtk n"),
    @NamedQuery(name = "Nhomtk.findByIdNhom", query = "SELECT n FROM Nhomtk n WHERE n.idNhom = :idNhom"),
    @NamedQuery(name = "Nhomtk.findByTenNhom", query = "SELECT n FROM Nhomtk n WHERE n.tenNhom = :tenNhom"),
    @NamedQuery(name = "Nhomtk.findByMoTa", query = "SELECT n FROM Nhomtk n WHERE n.moTa = :moTa")})
public class Nhomtk implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNhom")
    private Integer idNhom;
    @Size(max = 50)
    @Column(name = "tenNhom")
    private String tenNhom;
    @Size(max = 250)
    @Column(name = "moTa")
    private String moTa;
    @OneToMany(mappedBy = "idNhom")
    private List<Taikhoan> taikhoanList;

    public Nhomtk() {
    }

    public Nhomtk(Integer idNhom) {
        this.idNhom = idNhom;
    }

    public Integer getIdNhom() {
        return idNhom;
    }

    public void setIdNhom(Integer idNhom) {
        this.idNhom = idNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
        hash += (idNhom != null ? idNhom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhomtk)) {
            return false;
        }
        Nhomtk other = (Nhomtk) object;
        if ((this.idNhom == null && other.idNhom != null) || (this.idNhom != null && !this.idNhom.equals(other.idNhom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emtities.Nhomtk[ idNhom=" + idNhom + " ]";
    }
    
}
