package com.skhata.schoolMgmtSystem.model;

import com.skhata.schoolMgmtSystem.Enum.UserStatus;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static com.skhata.schoolMgmtSystem.constants.Constants.*;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */

@Entity
@Table(name = USER_TABLE_NAME)
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String fullName;

    @NaturalId
    @Column(length = 45)
    private String username;

    @NaturalId
    @Column(length = 45)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(length = 45)
    private UserStatus status;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = USER_ROLES_TABLE_NAME,
            joinColumns = @JoinColumn(name = USER_ID_COL_NAME),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID_COL_NAME))
    private List<Role> roles = new ArrayList<>();

    public User() {

    }

    public User(String fullName, String username, String email, String password, UserStatus status) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public User(String fullName, String username, String email, String password, UserStatus status, List<Role> roles) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void addRole(Role role) {
        roles.add(role);
        role.getUser().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUser().remove(this);
    }
}