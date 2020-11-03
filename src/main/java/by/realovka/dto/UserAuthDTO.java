package by.realovka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserAuthDTO {
    @NotEmpty
    @NotBlank
    private String loginUserAuthDTO;
    @NotEmpty
    @NotBlank
    private String passwordUserAuthDTO;

    public UserAuthDTO(String loginUserAuthDTO, String passwordUserAuthDTO) {
        this.loginUserAuthDTO = loginUserAuthDTO;
        this.passwordUserAuthDTO = passwordUserAuthDTO;
    }

    public UserAuthDTO() {
    }

    public String getLoginUserAuthDTO() {
        return loginUserAuthDTO;
    }

    public void setLoginUserAuthDTO(String loginUserAuthDTO) {
        this.loginUserAuthDTO = loginUserAuthDTO;
    }

    public String getPasswordUserAuthDTO() {
        return passwordUserAuthDTO;
    }

    public void setPasswordUserAuthDTO(String passwordUserAuthDTO) {
        this.passwordUserAuthDTO = passwordUserAuthDTO;
    }
}
