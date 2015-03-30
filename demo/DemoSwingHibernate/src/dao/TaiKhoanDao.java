package dao;

import java.util.*;
import entities.*;
import org.hibernate.*;

public class TaiKhoanDao {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Taikhoan> findAll(){
        try {
            sf.getCurrentSession().beginTransaction();
            List<Taikhoan> tks = sf.getCurrentSession().createCriteria(Taikhoan.class).list();
            sf.getCurrentSession().close();
            return tks;
        } catch (HibernateException e) {
            return null;
        }
    }
    
    public Taikhoan find(String username){
        
        try {
            sf.getCurrentSession().beginTransaction();
            //System.out.println(sf.getCurrentSession().get(Taikhoan.class, username));
            //return null; 
            Taikhoan tk = (Taikhoan)sf.getCurrentSession().get(Taikhoan.class, username);
            sf.getCurrentSession().close();
            return tk;
        } catch (HibernateException e) {
            return null;
        }
    }
    
    public boolean delete(Taikhoan tk){
        try {
         sf.getCurrentSession().beginTransaction();
         sf.getCurrentSession().delete(tk);
         sf.getCurrentSession().getTransaction().commit();
         sf.getCurrentSession().close();
         return true;
        } catch (HibernateException e) {
         sf.getCurrentSession().getTransaction().rollback();
         sf.getCurrentSession().close();
         return false;
        }
    }
    
    public boolean save(Taikhoan tk){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(tk);
            sf.getCurrentSession().getTransaction().commit();
            sf.getCurrentSession().close();
            return true;
            
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            sf.getCurrentSession().close();
            return false;
        }
    }
    
    public boolean update(Taikhoan tk){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().update(tk);
            sf.getCurrentSession().getTransaction().commit();
            sf.getCurrentSession().close();
            return true;
            
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            sf.getCurrentSession().close();
            return false;
        }
    }
    
    
}
