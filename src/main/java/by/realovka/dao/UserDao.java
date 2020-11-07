package by.realovka.dao;

import by.realovka.entity.User;

public interface UserDao  {
    void save(User user);
    boolean findByLogin(String login);
    boolean findByLoginAndPassword(String login, String password);
    User findUserByLogin(String login);
    void updateUser(User user);
}
