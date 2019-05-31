package com.level.Managers;

import dao.entity.User;
import hibernateFactory.Factory;

import java.sql.SQLException;
import java.util.Map;

public class LoginManager {
    public String[] loginController(String login, String password) throws Exception {
        String[] resultData = new String[2];
        User currentUser = null;

        try {
            currentUser = Factory.getInstance().getUserDAO().getUserByName(login);
            System.out.println(currentUser);
        } catch (SQLException e) {
            System.err.println("Enable to connect or there is not user");
            e.printStackTrace();
        }
        if (currentUser != null) {
            System.out.println("currentYser != null");
            String correctPassword = currentUser.getPassword();
            System.out.println(correctPassword);
            if (password.equals(correctPassword)) {
                System.out.println(password + "   " + correctPassword);
                System.out.println(currentUser.getUsername());
                resultData[0] = currentUser.getUsername();
                System.out.println(currentUser.getUsername());
                resultData[1] = String.valueOf(currentUser.getId());
                System.out.println(currentUser.getId());
                return resultData;
            }
        } else {
            throw new Exception();
        }
        return resultData;
    }
}
