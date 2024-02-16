package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    UserDao userDao;


    @Override
    @Transactional
    public User getUserById(int  id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void add(User user){
        userDao.add(user);
    }

    @Override
    @Transactional
    public void removeById(int id) {
        userDao.removeById(id);
    }

    @Transactional
    public List<User> getAll(){
        return userDao.getAll();
    }

}
