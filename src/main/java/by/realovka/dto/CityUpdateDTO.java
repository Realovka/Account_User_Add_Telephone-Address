package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CityUpdateDTO {

    private long id;
    @NotEmpty
    @NotBlank
    private String city;

    public CityUpdateDTO(long id, String city) {
        this.id = id;
        this.city = city;
    }

    public CityUpdateDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
