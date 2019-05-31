package com.level.Managers;

import dao.entity.Model;
import dao.entity.Product;
import dao.entity.ProductCategory;
import dao.interfaces.ProductDAO;
import hibernateFactory.Factory;
import hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static dao.entity.CategoryList.videocards;

public class ProductManager {

    private ProductDAO productDAO;

    public List<Product> getProducts(String category) {
        List<Product> products = null;

        try {
            productDAO = Factory.getInstance().getProductDAO();
        } catch (Exception e){
            e.printStackTrace();
        }
            switch (category) {
                case "videocards":
                    products = productDAO.getByCategory(category);
                    break;
                case "motherboards": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "controllers": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "processors": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "memory": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "sound": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "monitors": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "gamepads": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "keyboards": {
                    products = productDAO.getByCategory(category);
                    break;
                }
                case "all":{
                    products = productDAO.getAll();
                }
            }
        return products;
    }


    public Product getById(String id) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + id);
        Product product = null;
        try {
            productDAO = Factory.getInstance().getProductDAO();
        }catch (Exception e){
            e.printStackTrace();
        }
        product = productDAO.getById(Long.parseLong(id));
        return product;
    }
}
