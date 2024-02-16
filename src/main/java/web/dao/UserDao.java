package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public User getUserById(int  id);
    void add(User user);
    void removeById (int id);

    public List<User> getAll();

}
