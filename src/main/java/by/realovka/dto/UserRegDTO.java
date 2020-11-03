package by.realovka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class UserRegDTO {
    @NotBlank
    @NotEmpty
    private String nameUserRegDTO;
    @NotBlank
    @NotEmpty
    private String loginUserRegDTO;
    @NotBlank
    @NotEmpty
    private String passwordUserRegDTO;

    public UserRegDTO(String nameUserRegDTO, String loginUserRegDTO, String passwordUserRegDTO) {
        this.nameUserRegDTO = nameUserRegDTO;
        this.loginUserRegDTO = loginUserRegDTO;
        this.passwordUserRegDTO = passwordUserRegDTO;
    }

    public UserRegDTO() {
    }

    public String getNameUserRegDTO() {
        return nameUserRegDTO;
    }

    public void setNameUserRegDTO(String nameUserRegDTO) {
        this.nameUserRegDTO = nameUserRegDTO;
    }

    public String getLoginUserRegDTO() {
        return loginUserRegDTO;
    }

    public void setLoginUserRegDTO(String loginUserRegDTO) {
        this.loginUserRegDTO = loginUserRegDTO;
    }

    public String getPasswordUserRegDTO() {
        return passwordUserRegDTO;
    }

    public void setPasswordUserRegDTO(String passwordUserRegDTO) {
        this.passwordUserRegDTO = passwordUserRegDTO;
    }
}
