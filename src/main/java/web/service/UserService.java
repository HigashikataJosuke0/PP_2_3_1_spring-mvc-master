package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public User getUserById(long  id);
    void save(User user);
    void removeById (long id);
    public List<User> getAll();
}
