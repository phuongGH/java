package emtities;

import emtities.Taikhoan;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-07-13T20:59:10")
@StaticMetamodel(Nhomtk.class)
public class Nhomtk_ { 

    public static volatile SingularAttribute<Nhomtk, Integer> idNhom;
    public static volatile SingularAttribute<Nhomtk, String> tenNhom;
    public static volatile ListAttribute<Nhomtk, Taikhoan> taikhoanList;
    public static volatile SingularAttribute<Nhomtk, String> moTa;

}