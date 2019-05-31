package com.level.Managers;

import dao.entity.Order;
import dao.entity.Product;
import dao.entity.User;
import dao.interfaces.OrderDAO;
import dao.interfaces.ProductDAO;
import dao.interfaces.UserDAO;
import hibernateFactory.Factory;

public class OrderManager {
    public void saveOrder(String username, String productId, String quantity){
        OrderDAO orderDAO = null;
        UserDAO userDAO;
        ProductDAO productDAO;
        User user = null;
        Product product = null;
        try{
            orderDAO = Factory.getInstance().getOrderDAO();
            userDAO = Factory.getInstance().getUserDAO();
            productDAO = Factory.getInstance().getProductDAO();
            user = userDAO.getUserByName(username);
            product = productDAO.getById(Long.parseLong(productId));
        } catch (Exception e){
            e.printStackTrace();
        }
        Order order = new Order(user,product,Integer.parseInt(quantity));
        orderDAO.add(order);
    }
}
