package by.realovka.service;

import by.realovka.dao.TelephoneDaoImpl;
import by.realovka.dto.TelephoneUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelephoneService {
    @Autowired
    private TelephoneDaoImpl telephoneDao;

    public void updateTelephone(long id, TelephoneUpdateDTO telephoneUpdateDTO){
        telephoneDao.updateTelephone(id,telephoneUpdateDTO.getNumber());
    }

    public void deleteTelephone(long id){
        telephoneDao.deleteTelephone(id);
    }
}
