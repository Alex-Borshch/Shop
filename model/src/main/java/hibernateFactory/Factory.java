package hibernateFactory;




import dao.entity.Role;
import dao.implementations.*;


import dao.interfaces.*;

/**
 * Created by Nataliya on 17.02.2017.
 */
public class Factory {

    private static UserDAO userDAO = null;

    private static ProductDAO productDAO = null;
    private static RoleDAO roleDAO = null;
    private static OrderDAO orderDAO = null;
    private static ProductCategoryDAO productCategoryDAO = null;


    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
    public ProductDAO getProductDAO(){
        if (productDAO == null){
            productDAO = new ProductDAOImpl();
        }
        return productDAO;
    }
    public RoleDAO getRoleDAO(){
        if (roleDAO == null){
            roleDAO = new RoleDAOImpl();
        }
        return roleDAO;
    }
    public ProductCategoryDAO getProductCategoryDAO(){
        if (productCategoryDAO == null){
            productCategoryDAO = new ProductCategoryDAOImpl();
        }
        return productCategoryDAO;
    }
    public OrderDAO getOrderDAO(){
        if (orderDAO == null){
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }
   
}