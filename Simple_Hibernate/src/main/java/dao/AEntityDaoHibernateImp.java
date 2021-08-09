package dao;

import entities.AEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class AEntityDaoHibernateImp implements EntityDao<AEntity> {
    @Override
    public void add(AEntity obj) {
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
    public AEntity findById(long id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(AEntity.class, id);
        }
    }

    @Override
    public List<AEntity> findAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM AEntity", AEntity.class).list();
        }
    }

    @Override
    public void update(AEntity obj) {
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
