package by.realovka.service;

import by.realovka.dao.UserDaoImpl;
import by.realovka.dto.AddressDTO;
import by.realovka.dto.TelephoneDTO;
import by.realovka.dto.UserAuthDTO;
import by.realovka.dto.UserRegDTO;
import by.realovka.entity.Address;
import by.realovka.entity.Telephone;
import by.realovka.entity.User;
import by.realovka.service.Exception.NoSuchUserException;
import by.realovka.service.Exception.SuchUserIsPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {


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
            throw new SuchUserIsPresentException();
        } else return false;
    }

    public User findAuthUserByLogin(UserAuthDTO userAuthDTO){
        return userDaoImpl.findUserByLogin(userAuthDTO.getLoginUserAuthDTO());
    }


    public User getAuthUser(User user){
        return userDaoImpl.findUserByLogin(user.getLogin());
    }

    public void updateUserAddTelephone(User userAuth, TelephoneDTO telephoneDTO, HttpSession httpSession){
       List<Telephone> telephones=(List<Telephone>) httpSession.getAttribute("telephones");
        Telephone telephone = new Telephone(telephoneDTO.getNumber(),telephoneDTO.getCategory());
        telephones.add(telephone);
        userAuth.setTelephones(telephones);
        userDaoImpl.updateUser(userAuth);
    }

    public void updateUserAddAddress(User userAuth, AddressDTO addressDTO, HttpSession httpSession){
        List<Address> addresses = (List<Address>) httpSession.getAttribute("addresses");
        Address address = new Address(addressDTO.getCity(),addressDTO.getStreet(),addressDTO.getHouse(),addressDTO.getFlat(),addressDTO.getCategory());
        addresses.add(address);
        userAuth.setAddresses(addresses);
        userDaoImpl.updateUser(userAuth);
    }
}
