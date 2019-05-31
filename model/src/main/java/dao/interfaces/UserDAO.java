package dao.interfaces;

import dao.entity.User;

import java.sql.SQLException;

public interface UserDAO extends ItemDAO<User> {
    User getUserByName(String name) throws SQLException;
    User getUserById (long id) throws SQLException;
}
