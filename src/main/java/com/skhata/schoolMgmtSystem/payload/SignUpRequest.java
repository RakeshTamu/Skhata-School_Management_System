package com.skhata.schoolMgmtSystem.payload;

import com.skhata.schoolMgmtSystem.Enum.UserStatus;
import com.skhata.schoolMgmtSystem.model.Role;
import org.hibernate.annotations.NaturalId;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

import static com.skhata.schoolMgmtSystem.constants.Messages.*;

/**
 * Created by Rakesh Gurung on 19,Aug,2019
 */
public class SignUpRequest {

    @NotBlank(message = FULL_NAME_EMPTY_MSG)
    @Size(min = 4, max = 45, message = FULL_NAME_LENGTH_INVALID_MSG)
    private String fullName;

    @NaturalId
    @NotBlank(message = USERNAME_EMPTY_MSG)
    @Size(min = 3, max = 45, message = USERNAME_LENGTH_INVALID_MSG)
    private String username;

    @NotBlank(message = EMAIL_EMPTY_MSG)
    @Size(min = 5, max = 45, message = EMAIL_LENGTH_INVALID_MSG)
    @Email(message = EMAIL_INVALID_MSG)
    private String email;

    @NotBlank(message = PASSWORD_EMPTY_MSG)
    @Size(min = 6, max = 45, message = PASSWORD_LENGTH_INVALID_MSG)
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private UserStatus status;

    private List<Role> roles = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
