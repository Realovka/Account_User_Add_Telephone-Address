package by.realovka.dao;

public interface AddressDao {
    void deleteAddress(long id);
    void updateCity(long id, String city);
    void updateStreet(long id, String street);
    void updateHouse(long id, String house);
    void updateFlat(long id, String flat);
}
