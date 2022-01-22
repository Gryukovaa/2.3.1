package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(long id, User user) {
        User newUser = getUser(id);
        newUser.setLastname(user.getLastname());
        newUser.setFirstname(user.getFirstname());
        newUser.setEmail(user.getEmail());
        entityManager.persist(newUser);
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
        /*String hql = "FROM User users WHERE users.id =: id";
        TypedQuery <User> typedQuery = sessionFactory.getCurrentSession().createQuery(hql);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();*/
    }
}
