package dao.implementations;

import dao.entity.Model;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class HibernateAbstractDAO<T extends Model> {


    private Class<T> clazz;

    public HibernateAbstractDAO() {

        final ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) ((ParameterizedType) superClass).getActualTypeArguments()[0];

    }

    public List<T> getAll() {
        List<T> result = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(this.clazz);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            result = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public T getById(long id) {
        T model = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(this.clazz);
            criteria.add(Restrictions.eq("id", id));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            model = (T) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    public void add (T model) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update (T model){
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void remove (T model){
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(model);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
