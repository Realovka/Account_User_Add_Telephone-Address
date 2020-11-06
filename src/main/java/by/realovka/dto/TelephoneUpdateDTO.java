package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TelephoneUpdateDTO {

    private long id;
    @NotBlank
    @NotEmpty
    private String number;

    public TelephoneUpdateDTO(long id, String number) {
        this.id = id;
        this.number = number;
    }

    public TelephoneUpdateDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
