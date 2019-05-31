package com.level;

import dao.entity.*;

import dao.interfaces.OrderDAO;
import dao.interfaces.ProductCategoryDAO;
import dao.interfaces.ProductDAO;
import dao.interfaces.UserDAO;
import hibernateFactory.Factory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import org.json.simple.JSONStreamAware;

import java.math.BigDecimal;
import java.sql.SQLException;

import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = Factory.getInstance().getUserDAO() ;
        ProductCategoryDAO productCategoryDAO = Factory.getInstance().getProductCategoryDAO();
        ProductDAO productDAO = Factory.getInstance().getProductDAO();
        OrderDAO orderDAO= orderDAO = Factory.getInstance().getOrderDAO();

//        OrderDAO orderDAO = Factory.getInstance().getOrderDAO();
//
        ProductCategory videocards = new ProductCategory("videocards","images/categories/videocards.png",
                "videocards.html");
        ProductCategory processors = new ProductCategory("processors","images/categories/processors.png",
                "processors.html");
        ProductCategory memory = new ProductCategory("memory","images/categories/memory.png",
                "memory.html");
       ProductCategory controllers = new ProductCategory("controllers","images/categories/controllers.png",
               "controllers.html");
        ProductCategory motherboards = new ProductCategory("motherboards","images/categories/mothers.png",
                "motherboards.html");
        ProductCategory sound = new ProductCategory("sound","images/categories/sound.png",
                "sound.html");
        ProductCategory powerblocks = new ProductCategory("powerblocks","images/categories/powerblock.png",
                "powerblocks");
        ProductCategory monitors = new ProductCategory("monitors","images/categories/monitors.png",
                "monitors.html");
        ProductCategory mouses = new ProductCategory("mouses","images/categories/mouth.png",
                "mouses.html");
        ProductCategory gamepads = new ProductCategory("gamepads","images/categories/mouth.png",
                "gamepads.html");
        ProductCategory routers = new ProductCategory("routers","images/categories/routers.png",
                "routers.html");

        productCategoryDAO.add(videocards);
        productCategoryDAO.add(processors);
        productCategoryDAO.add(memory);
       productCategoryDAO.add(controllers);
       productCategoryDAO.add(routers);
       productCategoryDAO.add(gamepads);
       productCategoryDAO.add(mouses);
       productCategoryDAO.add(monitors);
       productCategoryDAO.add(powerblocks);
       productCategoryDAO.add(sound);
       productCategoryDAO.add(motherboards);

        System.out.println(userDAO.getUserByName("Alex"));
//
//        Role admin = new Role(RoleList.ADMIN);
//        Role customer = new Role(RoleList.USER);
//
//        roleDAO.add(admin);
//        roleDAO.add(customer);
//
//        Product videocard1 = new Product("videocard1", "1Gb", BigDecimal.valueOf(10.10), 10);
//        Product videocard2 = new Product("videocard2", "1.1Gb", BigDecimal.valueOf(11.11), 11);
//        Product videocard3 = new Product("videocard3", "1.2Gb", BigDecimal.valueOf(10.10), 10);
//        Product videocard4 = new Product("videocard4", "1.3Gb", BigDecimal.valueOf(13.13), 10);
//
//        videocard1.setProductCategory(videocards);
//        videocard2.setProductCategory(videocards);
//        videocard3.setProductCategory(videocards);
//        videocard4.setProductCategory(videocards);
//
//        productDAO.add(videocard1);
//        productDAO.add(videocard2);
//        productDAO.add(videocard3);
//        productDAO.add(videocard4);
//
        Product proc1 = new Product("proc1","Intel/",BigDecimal.valueOf(20.20),10);
        Product proc2 = new Product("proc2","Intel//",BigDecimal.valueOf(22.23),10);
        Product proc3 = new Product("proc3","AMD",BigDecimal.valueOf(20.20),10);
        Product proc4 = new Product("proc3","AMDD",BigDecimal.valueOf(50.21),10);
//
        proc4.setProductCategory(processors);
        proc1.setProductCategory(processors);
        proc2.setProductCategory(processors);
        proc3.setProductCategory(processors);
//
        productDAO.add(proc1);
        productDAO.add(proc2);
        productDAO.add(proc3);
        productDAO.add(proc4);
//
//        User alex = new User("Admin", "123456789");
//        userDAO.add(alex);
//        User baba = new User("Customer", "123456");
//        userDAO.add(baba);
//
//
//        List<Product> list = productDAO.getAll();
//        User user = userDAO.getUserByName("Admin");
//
//        System.out.println(user);

        Product videocard1 = new Product("videocard1", "description 1",
                BigDecimal.valueOf(9444.0),50,videocards,"images/categories/videocards/1.jpg");
        Product videocard2 = new Product("videocard2", "description 2", BigDecimal.valueOf(11.11),
                60, videocards, "images/categories/videocards/2.jpg");
        Product videocard3 = new Product("videocard3", "description 3", BigDecimal.valueOf(110.11),
                34,videocards,"images/categories/videocards/3.jpg");
        Product videocard4 = new Product("videocard4", "description 4", BigDecimal.valueOf(65.21),
                51,videocards,"images/categories/videocards/4.jpg");
        Product videocard5 = new Product("videocard5", "description 5", BigDecimal.valueOf(894.04),
                110,videocards,"images/categories/videocards/5.jpg");
        Product videocard6 = new Product("videocard6", "description 6", BigDecimal.valueOf(6548.02),
                5,videocards,"images/categories/videocards/6.jpg");

        productDAO.add(videocard1);
        productDAO.add(videocard2);
        productDAO.add(videocard3);
        productDAO.add(videocard4);
        productDAO.add(videocard5);
        productDAO.add(videocard6);

        User Alex = new User("Alex","123456");
        userDAO.add(Alex);

        orderDAO.add(new Order(Alex,videocard6,6));

    }
}
