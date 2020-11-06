package by.realovka.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class TelephoneDaoImpl implements TelephoneDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void updateTelephone(long id, String number) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("update Telephone  set number =: number where id =: id")
                .setParameter("number",number)
                .setParameter("id", id)
                .executeUpdate();
    }

    public void deleteTelephone(long id){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("delete Telephone where id =: id")
                .setParameter("id",id).executeUpdate();
//        currentSession.createQuery("")
    }
}
