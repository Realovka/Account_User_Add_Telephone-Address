package by.realovka.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {
   @Autowired
   private SessionFactory sessionFactory;

   public void deleteAddress(long id){
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.createQuery("update Address set deleted='true' where id =: id").setParameter("id",id);
   }

   public void updateCity(long id, String city){
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.createQuery("update Address set city =:city where id =: id").setParameter("city", city).setParameter("id",id)
              .executeUpdate();
   }

   public void updateStreet(long id, String street){
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.createQuery("update Address set street =:street where id =: id").setParameter("street", street).setParameter("id",id)
              .executeUpdate();
   }

   public void updateHouse(long id, String house){
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.createQuery("update Address set house =:house where id =: id").setParameter("house", house).setParameter("id",id)
              .executeUpdate();
   }

   public void updateFlat(long id, String flat){
      Session currentSession = sessionFactory.getCurrentSession();
      currentSession.createQuery("update Address set flat =:flat where id =: id").setParameter("flat", flat).setParameter("id",id)
              .executeUpdate();
   }
}
