package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.*;
import java.util.*;

@ManagedBean
@SessionScoped
public class SinhVienManagedBean {

    SinhVien sv;
    List<SinhVien> lsv =new ArrayList<SinhVien>();

    public List<SinhVien> getLsv() {
        return lsv;
    }

    public void setLsv(List<SinhVien> lsv) {
        this.lsv = lsv;
    }
    
    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }
    
    public SinhVienManagedBean() {
    }
    
    public String thongtinsinhvien(){
        sv = new SinhVien("SV01", "Ngyen Van A", "Thanh Thai");
        return "thongtinsinhvien";
    }
    
    public String danhsachsinhvien(){
        for(int i=1;i<5;i++)
        {
            lsv.add(new SinhVien("SV"+i, "Sinh vien "+i, "dia chi Sinh vien " +i));
        }
        return "danhsachsinhvien";
    }
}
