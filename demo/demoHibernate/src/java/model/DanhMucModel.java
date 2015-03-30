package model;

import entities.*;
import java.util.*;
import org.hibernate.*;

public class DanhMucModel {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Danhmuc> danhsach(){
        try {
            sf.getCurrentSession().beginTransaction();
            List<Danhmuc> rerult = sf.getCurrentSession().createCriteria(Danhmuc.class).list();
            return rerult;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Danhmuc thongtin(Integer madanhmuc){
        try { 
            sf.getCurrentSession().beginTransaction();
            return (Danhmuc) sf.getCurrentSession().get(Danhmuc.class, madanhmuc);
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean xoa(Danhmuc dm){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(dm);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    
    public boolean them(Danhmuc dm){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().saveOrUpdate(dm);
            sf.getCurrentSession().getTransaction().commit();
            return true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
}
