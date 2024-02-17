package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(long  id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public List<User> getAll(){
        return entityManager.createQuery("from User user", User.class)
                .getResultList();
    }
}
