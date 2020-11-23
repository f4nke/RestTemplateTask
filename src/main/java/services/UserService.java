package services;

import model.User;


import java.util.List;

public interface UserService {
    List<User> findAll();
    void edit(User user);
    void save(User user);
    void delete(long id);
}
