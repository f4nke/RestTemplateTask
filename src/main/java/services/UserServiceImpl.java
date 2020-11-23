package services;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void edit(User user) {
        userRepo.save(user);
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void delete(long id) {
        userRepo.deleteById(id);
    }
}
