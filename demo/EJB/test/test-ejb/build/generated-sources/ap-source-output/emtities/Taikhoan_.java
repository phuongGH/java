package emtities;

import emtities.Nhomtk;
import emtities.Thanhvien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-13T20:59:10")
@StaticMetamodel(Taikhoan.class)
public class Taikhoan_ { 

    public static volatile SingularAttribute<Taikhoan, Thanhvien> thanhVienID;
    public static volatile SingularAttribute<Taikhoan, Nhomtk> idNhom;
    public static volatile SingularAttribute<Taikhoan, Date> ngayTao;
    public static volatile SingularAttribute<Taikhoan, String> userName;
    public static volatile SingularAttribute<Taikhoan, String> password;
    public static volatile SingularAttribute<Taikhoan, String> ghiChu;

}