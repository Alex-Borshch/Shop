package com.level.Managers;

import dao.entity.User;
import dao.interfaces.UserDAO;
import hibernateFactory.Factory;

public class RegistrationManager {

    public String[] register(String name, String password, String email) throws Exception {
        String[] resultData = new String[4];
        User user = new User(name, password,email);
        UserDAO userDAO = null;
        try {
            userDAO = Factory.getInstance().getUserDAO();
        } catch (Exception e) {
            System.err.println("Enable to connect");
            e.printStackTrace();
        }

        if (userDAO != null) {
            userDAO.add(user);
            resultData[0] = user.getUsername();
            resultData[1] = user.getPassword();
            resultData[2] = user.getEmail();
            resultData[3] = String.valueOf(user.getId());
            return resultData;
        } else {
            throw new Exception();
        }
    }
}
