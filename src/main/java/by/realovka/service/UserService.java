package by.realovka.service;

import by.realovka.dao.UserDaoImpl;
import by.realovka.dto.TelephoneDTO;
import by.realovka.dto.UserAuthDTO;
import by.realovka.dto.UserRegDTO;
import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import by.realovka.service.Exception.NoSuchUserException;
import by.realovka.service.Exception.SuchUserIsPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

//    private List<Telephone> telephones;

    @Autowired
    private UserDaoImpl userDaoImpl;

    public void save(UserRegDTO userRegDTO){
        User user = new User(userRegDTO.getNameUserRegDTO(),userRegDTO.getLoginUserRegDTO(),userRegDTO.getPasswordUserRegDTO());
        userDaoImpl.save(user);
    }

    public boolean findByLoginAndPassword(UserAuthDTO userAuthDTO){
       if(!userDaoImpl.findByLoginAndPassword(userAuthDTO.getLoginUserAuthDTO(),userAuthDTO.getLoginUserAuthDTO())){
           throw new NoSuchUserException();
       } else return true;
    }

    public boolean findByLogin(UserRegDTO userRegDTO){
        if(userDaoImpl.findByLogin(userRegDTO.getLoginUserRegDTO())){
            throw new SuchUserIsPresent();
        } else return false;
    }

    public User findAuthUserByLogin(UserAuthDTO userAuthDTO){
        return userDaoImpl.findUserByLogin(userAuthDTO.getLoginUserAuthDTO());
    }


    public User getAuthUser(User user){
        return userDaoImpl.findUserByLogin(user.getLogin());
    }

    public void updateUserAddTelephone(User userAuth, TelephoneDTO telephoneDTO){
        List<Telephone> telephones = new ArrayList<>();
        Telephone telephone = new Telephone(telephoneDTO.getNumber(),telephoneDTO.getCategory());
        telephones.add(telephone);
        userAuth.setTelephones(telephones);
        userDaoImpl.updateUser(userAuth);

    }
}
