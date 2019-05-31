package dao.implementations;

import dao.entity.Order;
import dao.interfaces.OrderDAO;

import java.util.List;

public class OrderDAOImpl extends HibernateAbstractDAO<Order> implements OrderDAO {

    @Override
    public List<Order> getAll() {
        return super.getAll();
    }

    @Override
    public Order getById(long id) {
        return super.getById(id);
    }

    @Override
    public void add(Order model) {
        super.add(model);
    }

    @Override
    public void update(Order model) {
        super.update(model);
    }

    @Override
    public void remove(Order model) {
        super.remove(model);
    }
}
