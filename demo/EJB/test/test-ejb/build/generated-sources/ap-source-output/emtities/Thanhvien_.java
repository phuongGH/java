package emtities;

import emtities.Taikhoan;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-13T20:59:10")
@StaticMetamodel(Thanhvien.class)
public class Thanhvien_ { 

    public static volatile SingularAttribute<Thanhvien, String> ten;
    public static volatile SingularAttribute<Thanhvien, Integer> gioiTinh;
    public static volatile SingularAttribute<Thanhvien, String> chucDanh;
    public static volatile SingularAttribute<Thanhvien, String> ho;
    public static volatile SingularAttribute<Thanhvien, String> ghiChu;
    public static volatile SingularAttribute<Thanhvien, String> chuyenMon;
    public static volatile SingularAttribute<Thanhvien, String> thanhVienID;
    public static volatile SingularAttribute<Thanhvien, Integer> loaiTV;
    public static volatile SingularAttribute<Thanhvien, String> soDT1;
    public static volatile SingularAttribute<Thanhvien, String> email;
    public static volatile SingularAttribute<Thanhvien, String> soDT2;
    public static volatile SingularAttribute<Thanhvien, String> ngaySinh;
    public static volatile SingularAttribute<Thanhvien, String> diaChi;
    public static volatile ListAttribute<Thanhvien, Taikhoan> taikhoanList;

}