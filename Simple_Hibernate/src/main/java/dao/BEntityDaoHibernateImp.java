package dao;

import entities.BEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class BEntityDaoHibernateImp implements EntityDao<BEntity> {
    @Override
    public void add(BEntity obj) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        }
        catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public BEntity findById(long id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(BEntity.class, id);
        }
    }

    @Override
    public List<BEntity> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM BEntity", BEntity.class).list();
        }
    }

    @Override
    public void update(BEntity obj) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(obj);
            transaction.commit();
        }
        catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}
