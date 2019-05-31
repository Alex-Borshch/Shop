package dao.implementations;

import dao.entity.User;
import dao.interfaces.UserDAO;
import hibernateFactory.*;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;


public class UserDAOImpl extends HibernateAbstractDAO<User> implements UserDAO {


    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User getById(long id) {
        return super.getById(id);
    }

    @Override
    public void add(User model) {
        super.add(model);
    }

    @Override
    public void update(User model) {
        super.update(model);
    }

    @Override
    public void remove(User model) {
        super.remove(model);
    }

    public User getUserByName(String username) {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User D WHERE D.username =:paramName");
            query.setParameter("paramName", username);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserById(long id) throws SQLException {
        User user = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User WHERE id =:paramId");
            query.setParameter("paramId", id);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

