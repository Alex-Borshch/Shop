package dao.implementations;

import dao.entity.Role;
import dao.interfaces.RoleDAO;

import java.util.List;

public class RoleDAOImpl extends HibernateAbstractDAO<Role> implements RoleDAO {

    @Override
    public List<Role> getAll() {
        return super.getAll();
    }

    @Override
    public Role getById(long id) {
        return super.getById(id);
    }

    @Override
    public void add(Role model) {
        super.add(model);
    }

    @Override
    public void update(Role model) {
        super.update(model);
    }

    @Override
    public void remove(Role model) {
        super.remove(model);
    }
}
