package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class HouseUpdateDTO {

    private long id;
    @NotEmpty
    @NotBlank
    private String house;

    public HouseUpdateDTO(long id, String house) {
        this.id = id;
        this.house = house;
    }

    public HouseUpdateDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }
}
