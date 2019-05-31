package com.webConvertation.controller;

import com.level.Managers.CategoryManager;
import dao.entity.ProductCategory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CategoryServlet extends MainServlet.RequestHandler {
    private static final CategoryServlet INSTANCE = new CategoryServlet();
    private CategoryServlet(){};

    @Override
    public JSONStreamAware executeRequest(HttpServletRequest req) throws Exception {
        System.out.println("CategoryServlet detected");
        CategoryManager manager = new CategoryManager();
        List<ProductCategory> categories = manager.getCategories();
        JSONArray response = new JSONArray();
        for (ProductCategory category :
                categories) {
            JSONObject object = new JSONObject();
            object.put("title",category.getTitle());
            object.put("img_path",category.getImgPath());
            object.put("path",category.getPath());
            response.add(object);
        }
        return response;
    }

    public static CategoryServlet getInstance(){
        return INSTANCE;
    }
}
