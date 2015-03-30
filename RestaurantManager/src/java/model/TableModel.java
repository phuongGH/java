package model;
import entities.*;
import java.util.*;
import org.hibernate.*;

public class TableModel {
    private final SessionFactory sf = HibernateUtil.getSessionFactory();
    private static TableModel tm;
    
    private TableModel(){
        
    }
    
    public static TableModel getTableModel(){
        if(tm != null)
        {
            return tm;
        }else
        {
            tm = new TableModel();
            return tm;
        }
    }
    

    
    
    public List<TableT> listTable(){
        try {
            sf.getCurrentSession().beginTransaction();            
            List<TableT> result = sf.getCurrentSession().createCriteria(TableT.class).list();
            sf.getCurrentSession().close();
            return result;
        } catch (HibernateException e) {
            return null;
        }
    }
    

    
       public  TableT getTable(int tableId){
        try {
            sf.getCurrentSession().beginTransaction();
            TableT tableOjb = (TableT) sf.getCurrentSession().get(TableT.class, tableId);
             sf.getCurrentSession().close();
             return tableOjb;
        } catch (HibernateException e) {
            return null;
        }
    }
    
    public boolean deleteTable(TableT tableOjb){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().delete(tableOjb);
            sf.getCurrentSession().getTransaction().commit();
            sf.getCurrentSession().close();
            return true;
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    
    public boolean insertTable(TableT tableOjb){
        try {
            sf.getCurrentSession().beginTransaction();
            sf.getCurrentSession().save(tableOjb);
            sf.getCurrentSession().getTransaction().commit();
            sf.getCurrentSession().close();
            return true;
        } catch (HibernateException e) {
            sf.getCurrentSession().getTransaction().rollback();
            return false;
        }
    }
    

}
