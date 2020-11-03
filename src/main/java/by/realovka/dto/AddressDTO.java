package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AddressDTO {
    @NotEmpty
    @NotBlank
    private String city;
    @NotEmpty
    @NotBlank
    private String street;
    @NotEmpty
    @NotBlank
    private String house;
    @NotEmpty
    @NotBlank
    private String flat;
    @NotEmpty
    @NotBlank
    private String category;

    public AddressDTO(String city, String street, String house, String flat, String category) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.category = category;
    }

    public AddressDTO() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
