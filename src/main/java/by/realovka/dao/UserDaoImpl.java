package by.realovka.dao;

import by.realovka.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public void save(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    public boolean findByLogin(String login){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User where login=: login", User.class).setParameter("login", login).getResultList().size()>0;
    }

    @Override
    public boolean findByLoginAndPassword(String login, String password){
        Session currentSession = sessionFactory.getCurrentSession();
        return  currentSession.createQuery("from User where login=: login and password=: password", User.class)
                .setParameter("login", login).setParameter("password", password).getResultList().size()>0;
    }

    @Override
    public User findUserByLogin(String login){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User where login=: login", User.class).setParameter("login", login).getSingleResult();
    }

    @Override
    public void updateUser(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
    }
}
