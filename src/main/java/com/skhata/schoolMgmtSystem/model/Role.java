package com.skhata.schoolMgmtSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.skhata.schoolMgmtSystem.constants.Constants.ROLE_TABLE_NAME;
import static com.skhata.schoolMgmtSystem.constants.Messages.ROLE_NAME_EMPTY_MSG;
import static com.skhata.schoolMgmtSystem.constants.Messages.ROLE_NAME_LENGTH_INVALID_MSG;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */
@Entity
@Table(name = ROLE_TABLE_NAME)
public class Role extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(length = 45)
    @NotBlank(message = ROLE_NAME_EMPTY_MSG)
    @Size(min = 2, max = 45, message = ROLE_NAME_LENGTH_INVALID_MSG)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> user = new ArrayList<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Role r = (Role) o;
        return Objects.equals(name, r.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
