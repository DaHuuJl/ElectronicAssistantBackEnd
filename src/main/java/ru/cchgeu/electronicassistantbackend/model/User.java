package ru.cchgeu.electronicassistantbackend.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usr")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_password")
    private String password;
}