package com.edu.eci.ieti.repository;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users") // Define el nombre de la colección
public class user {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    public user() {
    }

    public user(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

      public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
