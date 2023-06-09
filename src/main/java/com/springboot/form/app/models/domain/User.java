package com.springboot.form.app.models.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {

    private String id;
    @NotEmpty(message = "Cannot be null")
    private String name;
    @NotEmpty(message = "Cannot be null")
    private String lastname;
    @NotEmpty(message = "Cannot be null")
    @Size(min = 3, max = 8)
    private String username;
    @NotEmpty(message = "Cannot be null")
    private String password;
    @NotEmpty(message = "Cannot be null")
    @Email(message = "Wrong email format")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
