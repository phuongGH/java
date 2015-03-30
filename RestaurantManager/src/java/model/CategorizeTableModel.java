package model;
import entities.*;
import java.util.*;
import org.hibernate.*;


public class CategorizeTableModel {
    private static final SessionFactory sf = HibernateUtil.getSessionFactory();
    
    public List<Categorizetable> listCategorizeTable(){
        try {
            sf.getCurrentSession().beginTransaction();
            List<Categorizetable> result = sf.getCurrentSession().createCriteria(Categorizetable.class).list();
            sf.getCurrentSession().close();
            return result;
        } catch (HibernateException e) {
            return null;
        }
    }
    
    public static Categorizetable getCategorizeTable(String categorizeTableId){
        try {
             sf.getCurrentSession().beginTransaction();
            Categorizetable result = (Categorizetable) sf.getCurrentSession().createCriteria(Categorizetable.class, categorizeTableId);
            sf.getCurrentSession().close();
            return result;
        } catch (HibernateException e) {
            return null;
        }
    }
}
