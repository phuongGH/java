package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class DangNhapManagedBean {

    private String username;
    private String pass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public DangNhapManagedBean() {
    }
    
    
    public String dangnhap(){
        String page;
        if(this.username.equals("a")&&this.pass.equals("b")){
            page="wellcome";
        }else
        {
            page="dangnhap"; 
        }
        return page;
    }
}
