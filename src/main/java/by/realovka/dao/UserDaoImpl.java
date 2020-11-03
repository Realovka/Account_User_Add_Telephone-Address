package by.realovka.dao;

import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl {

    @Autowired
    public SessionFactory sessionFactory;

    public void save(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public boolean findByLogin(String login){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User where login=: login", User.class).setParameter("login", login).getResultList().size()>0;
    }

    public boolean findByLoginAndPassword(String login, String password){
        Session currentSession = sessionFactory.getCurrentSession();
        return  currentSession.createQuery("from User where login=: login and password=: password", User.class)
                .setParameter("login", login).setParameter("password", password).getResultList().size()>0;
    }

    public User findUserByLogin(String login){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User where login=: login", User.class).setParameter("login", login).getSingleResult();
    }

    public void updateUser(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
    }
}
