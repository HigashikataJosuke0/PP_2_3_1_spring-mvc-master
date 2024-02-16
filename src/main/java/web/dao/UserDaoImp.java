package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(int  id) {

        return null;
    }

    @Override
    public void add(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeById(int id) {

    }

    public List<User> getAll(){
        return entityManager.createQuery("select u from  User u", User.class)
                .getResultList();
    }
}
