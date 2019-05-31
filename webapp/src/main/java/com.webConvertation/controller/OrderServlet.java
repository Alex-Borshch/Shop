package com.webConvertation.controller;

import com.level.Managers.OrderManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

public class OrderServlet extends MainServlet.RequestHandler{

        private static final OrderServlet INSTANCE = new OrderServlet();
        private OrderServlet(){}
        public static OrderServlet getInstance(){
            return INSTANCE;
        }
    @Override
    public JSONStreamAware executeRequest(HttpServletRequest req) throws Exception {
        String username = req.getParameter("user");
        String productId = req.getParameter("productId");
        String quantity = req.getParameter("quantity");
        OrderManager manager = new OrderManager();
        manager.saveOrder(username,productId,quantity);
        JSONObject object = new JSONObject();
        object.put("productId",productId);
        object.put("quantity",quantity);
        return object;
    }
}
