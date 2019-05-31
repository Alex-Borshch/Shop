package dao.implementations;

import dao.entity.ProductCategory;
import dao.interfaces.ProductCategoryDAO;

import java.util.List;

public class ProductCategoryDAOImpl extends HibernateAbstractDAO<ProductCategory> implements ProductCategoryDAO {
    @Override
    public List<ProductCategory> getAll() {
        return super.getAll();
    }

    @Override
    public ProductCategory getById(long id) {
        return super.getById(id);
    }

    @Override
    public void add(ProductCategory model) {
        super.add(model);
    }

    @Override
    public void update(ProductCategory model) {
        super.update(model);
    }

    @Override
    public void remove(ProductCategory model) {
        super.remove(model);
    }
}
