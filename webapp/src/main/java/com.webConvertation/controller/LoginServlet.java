package com.webConvertation.controller;
import com.level.Managers.LoginManager;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

public class LoginServlet extends MainServlet.RequestHandler {

    private static final LoginServlet INSTANCE = new LoginServlet();

    public static LoginServlet getInstance(){
        return INSTANCE;
    }

    private LoginServlet(){}


    @Override
    public JSONStreamAware executeRequest(HttpServletRequest req) throws Exception {
        JSONObject jsonObject = new JSONObject();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        LoginManager loginManager = new LoginManager();

        String[] loginData = null;

        try {
            loginData = loginManager.loginController(login,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        if (loginData == null){
            jsonObject.put("name","error");
            jsonObject.put("password","not_exist");
            return jsonObject;
        }
        jsonObject.put("username", loginData[0]);
        jsonObject.put("userId", loginData[1]);

        return jsonObject;
    }
}
