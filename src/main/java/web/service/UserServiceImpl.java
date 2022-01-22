package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id, user);
    }

    @Override
    public void deleteUser(User user) {
    userDao.deleteUser(user);
    }

    @Override
    public User getUser(Long id) {
        return  userDao.getUser(id);
    }
}
