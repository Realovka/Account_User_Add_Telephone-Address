package by.realovka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class FlatUpdateDTO {

    private long id;
    @NotBlank
    @NotEmpty
    private String flat;

    public FlatUpdateDTO(long id, String flat) {
        this.id = id;
        this.flat = flat;
    }

    public FlatUpdateDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
