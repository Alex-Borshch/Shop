package com.webConvertation.controller;


import com.level.Managers.RegistrationManager;
import dao.entity.User;
import hibernateFactory.Factory;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends MainServlet.RequestHandler {

    private static final RegistrationServlet INSTANCE = new RegistrationServlet();

    private RegistrationServlet(){}

    public static RegistrationServlet getInstance() {
        return INSTANCE;
    }

    @Override
    public JSONStreamAware executeRequest(HttpServletRequest req) throws Exception {
        RegistrationManager registrationManager = new RegistrationManager();
        JSONObject jsonObject = new JSONObject();
        String[] param;
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        try {
            param = registrationManager.register(login,password,email);
        }catch(Exception e){
            System.out.println("Exception in registration");
            jsonObject.put("name","error");
            jsonObject.put("password","not_exist");
            return jsonObject;
       }
        System.out.println("login: " + login + ";  password: " + password);
        jsonObject.put("username", param[0]);
        jsonObject.put("userId", param[3]);
        return jsonObject;
    }
}