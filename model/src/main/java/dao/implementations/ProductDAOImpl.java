package dao.implementations;


import dao.entity.Product;
import dao.entity.ProductCategory;
import dao.interfaces.ProductDAO;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;

public class ProductDAOImpl extends HibernateAbstractDAO<Product>  implements ProductDAO {


    @Override
    public List<Product> getAll() {
        return super.getAll();
    }

    @Override
    public Product getById(long id) {
        return super.getById(id);
    }

    @Override
    public void add(Product model) {
        super.add(model);
    }

    @Override
    public void update(Product model) {
        super.update(model);
    }

    @Override
    public void remove(Product model) {
        super.remove(model);
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            Query query = session.createQuery("FROM Product P WHERE P.productCategory.title = :productCategory");
            query.setParameter("productCategory",category);
            products = query.list();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
