package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TelephoneDTO {

    @NotBlank
    @NotEmpty
    private String number;
    @NotBlank
    @NotEmpty
    private String category;

    public TelephoneDTO(String number, String category) {
        this.number = number;
        this.category = category;
    }

    public TelephoneDTO(String number) {
        this.number = number;
    }

    public TelephoneDTO() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
