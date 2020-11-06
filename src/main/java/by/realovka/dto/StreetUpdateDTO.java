package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class StreetUpdateDTO {

    private long id;
    @NotBlank
    @NotEmpty
    private String street;

    public StreetUpdateDTO(long id, String street) {
        this.id = id;
        this.street = street;
    }

    public StreetUpdateDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
