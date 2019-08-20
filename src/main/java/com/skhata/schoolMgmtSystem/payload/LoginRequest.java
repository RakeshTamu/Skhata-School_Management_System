package com.skhata.schoolMgmtSystem.payload;

import javax.validation.constraints.NotBlank;

import static com.skhata.schoolMgmtSystem.constants.Messages.PASSWORD_EMPTY_MSG;
import static com.skhata.schoolMgmtSystem.constants.Messages.USERNAME_EMAIL_EMPTY_MSG;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */
public class LoginRequest {
    @NotBlank(message = USERNAME_EMAIL_EMPTY_MSG)
    private String usernameOrEmail;

    @NotBlank(message = PASSWORD_EMPTY_MSG)
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
