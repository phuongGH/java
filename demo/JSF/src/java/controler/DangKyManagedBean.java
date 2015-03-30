package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.*;

@ManagedBean
@RequestScoped
public class DangKyManagedBean {

    TaiKhoan tk = new TaiKhoan();

    public TaiKhoan getTk() {
        return tk;
    }

    public void setTk(TaiKhoan tk) {
        this.tk = tk;
    }
    
    public DangKyManagedBean() {
    }
    
    public String dangky(){
        return "thongtintaikhoan";
    }
}
