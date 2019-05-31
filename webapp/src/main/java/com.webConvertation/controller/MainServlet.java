package com.webConvertation.controller;

import com.webConvertation.utils.JSON;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.webConvertation.utils.JSONResponses.ERROR_INCORRECT_REQUEST;

public class MainServlet extends HttpServlet {
    public abstract static class RequestHandler {
        public abstract JSONStreamAware executeRequest(HttpServletRequest req) throws Exception;
    }
    private static Map<String, RequestHandler> requestMap= new HashMap();
    static {
        Map<String, RequestHandler> map = new HashMap<>();
        map.put("login",LoginServlet.getInstance());
        map.put("registration", RegistrationServlet.getInstance());
        map.put("product",ProductServlet.getInstance());
        map.put("categories", CategoryServlet.getInstance());
        map.put("order", OrderServlet.getInstance());
        requestMap = Collections.unmodifiableMap(map);
    }
    private static Map<String,RequestHandler> getRequestMap(){
        return requestMap;
    }
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processRequest(req,resp);
    }
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        processRequest(req,resp);
    }
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setDateHeader("Expires", 0);

        JSONStreamAware response = JSON.emptyJSON;
        try{
            long startTime = System.currentTimeMillis();

            String requestType = req.getParameter("requestType");
            System.out.println("getting request...");
            if (requestType == null) {
                response = ERROR_INCORRECT_REQUEST;
                return;
            }

            RequestHandler servlet = getRequestMap().get(requestType);
            if (servlet == null) {
                response = ERROR_INCORRECT_REQUEST;
                return;
            }
            System.out.println("Getting servlet...");
            response = servlet.executeRequest(req);
            if (response instanceof JSONObject) {
                ((JSONObject) response).put("requestProcessingTime", System.currentTimeMillis() - startTime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resp.setContentType("text/plain; charset=UTF-8");
            try (Writer writer = resp.getWriter()) {
                response.writeJSONString(writer);
            }
        }
    }




}
