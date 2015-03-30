package cotroller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.*;
import emtities.*;
import java.util.*;
import javax.ejb.EJB;

@ManagedBean
@RequestScoped
public class NhomTKManagedBean {
    @EJB
    private NhomtkFacade nhomtkFacade;

    private Nhomtk ntk = new Nhomtk();

    public Nhomtk getNtk() {
        return ntk;
    }

    public void setNtk(Nhomtk ntk) {
        this.ntk = ntk;
    }
    
    public NhomTKManagedBean() {
    }
    
    public List<Nhomtk> nhomtaikhoan(){
        return this.nhomtkFacade.findAll();
    }
    
    public void xoa(Nhomtk ntk){
         this.nhomtkFacade.remove(ntk);
    }
    
    public String them(){
        this.nhomtkFacade.create(this.ntk);
        return "index";
    }
    
    public String thongtinnhom(Nhomtk ntk){
        this.ntk = ntk;
        return "capnhatnhomtaikhoan";
    }
    
    public String capnhat(){
        this.nhomtkFacade.edit(this.ntk);
        return "index";
    }
}
