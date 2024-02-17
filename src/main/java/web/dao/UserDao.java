package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public User getUserById(long  id);
    void save(User user);
    void removeById (long id);

    public List<User> getAll();

}
