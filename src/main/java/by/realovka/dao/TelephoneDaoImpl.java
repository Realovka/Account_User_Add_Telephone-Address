package by.realovka.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TelephoneDaoImpl implements TelephoneDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void updateTelephone(long id, String number) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("update Telephone  set number =: number where id =: id")
                .setParameter("number",number)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void deleteTelephone(long id){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("delete Telephone where id =: id")
                .setParameter("id",id)
                .executeUpdate();

    }
}
