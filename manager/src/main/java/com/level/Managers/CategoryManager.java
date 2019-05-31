package com.level.Managers;

import dao.entity.ProductCategory;
import dao.interfaces.ProductCategoryDAO;
import hibernateFactory.Factory;
import java.util.List;

public class CategoryManager {

    ProductCategoryDAO productCategoryDAO;
    private List<ProductCategory> categories;

    public List<ProductCategory> getCategories() {
        try {
            productCategoryDAO = Factory.getInstance().getProductCategoryDAO();
            categories = productCategoryDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
