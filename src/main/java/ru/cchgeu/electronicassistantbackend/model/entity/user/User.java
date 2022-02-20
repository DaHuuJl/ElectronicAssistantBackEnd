package ru.cchgeu.electronicassistantbackend.model.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
//@Getter
//@Setter
//@Entity(name = "users")
//@NoArgsConstructor
//public class User {
//
//    @Id
//    @Column(name = "user_id")
//    @GeneratedValue(strategy =  GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "last_name")
//    private String lastName;
//
////    @Enumerated(EnumType.STRING)
////    private Role role;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "patronymic")
//    private String patronymic;
//
//    @Column(name = "course")
//    private Integer course;
//
//    @Column(name = "groupp")
//    private String groupp;
//
//    @Column(name = "facultet")
//    private String facultet;
//
//    @Column(name = "date_start")
//    private String date_start;
//
//    @Column(name = "date_end")
//    private String date_end;
//
//    @Column(name = "type_training")
//    private Type_training type_training;
//
//    @Column(name = "user_login")
//    private String login;
//
//    @Column(name = "user_password")
//    private String password;
//}
