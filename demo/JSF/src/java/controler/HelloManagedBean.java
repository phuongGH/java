package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class HelloManagedBean {

    String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
    
    public HelloManagedBean() {
    }
    
    public String kequa(){
        this.s = "Nguyen Vam A";
        return "ketqua";
    }
}
