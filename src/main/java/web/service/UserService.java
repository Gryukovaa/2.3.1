package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateUser(long id, User user);

    public void deleteUser(User user);

    public User getUser(Long id);
}
