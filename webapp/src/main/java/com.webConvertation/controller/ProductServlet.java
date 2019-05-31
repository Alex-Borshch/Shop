package com.webConvertation.controller;

import com.level.Managers.ProductManager;
import com.webConvertation.utils.JSONResponses;
import dao.entity.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProductServlet extends MainServlet.RequestHandler {

    private static final ProductServlet INSTANCE = new ProductServlet();

    private ProductServlet() {
    }

    public static ProductServlet getInstance() {
        return INSTANCE;
    }

    @Override
    public JSONStreamAware executeRequest(HttpServletRequest request) throws Exception {
        System.out.println("Servlet detected: ProductServlet");
        ProductManager productManager = new ProductManager();
        JSONObject incorrectParameters;
        String category = request.getParameter("category");
        String id = request.getParameter("id");

        if (category == null && id == null) {
            return JSONResponses.ERROR_INCORRECT_REQUEST;
        }
        if (category == null && id != null) {
            String idParam = request.getParameter("id");
            System.out.println("In ProductServlet id = " + idParam);
            Product product = productManager.getById(request.getParameter("id"));
            if (product == null) {
                return JSONResponses.ERROR_INCORRECT_REQUEST;
            }
            JSONObject response = new JSONObject();
            response.put("id", product.getId());
            response.put("title", product.getTitle());
            response.put("description", product.getDescription());
            response.put("img_path", product.getImagePath());
            response.put("price", product.getPrice());
            return response;
        }
        if (category != null && id == null) {
            System.out.println(category);
            List<Product> products = productManager.getProducts(category);
            if (products == null) {
                JSONObject object = new JSONObject();
                object.put("products", "there are no products or incorrect category");
                return object;
            }
            JSONArray response = new JSONArray();
            for (Product product :
                    products) {
                JSONObject object = new JSONObject();
                object.put("id", product.getId());
                object.put("title", product.getTitle());
                object.put("description", product.getDescription());
                object.put("price", product.getPrice());
                object.put("quantity", product.getQuantity());
                object.put("category", product.getProductCategory().getTitle());
                object.put("img_path", product.getImagePath());
                response.add(object);

            }
            return response;
        }
        incorrectParameters = new JSONObject();
        incorrectParameters.put("incorrectRequest", "choose only 1 parameter: category or id");

        return incorrectParameters;
    }
}
