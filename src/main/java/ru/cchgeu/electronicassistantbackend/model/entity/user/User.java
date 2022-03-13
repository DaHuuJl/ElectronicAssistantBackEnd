package ru.cchgeu.electronicassistantbackend.model.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "SEC_USERS")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "last_name")
    private String lastName;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "course")
    private Integer course;

    @Column(name = "groupp")
    private String groupp;

    @Column(name = "facultet")
    private String facultet;

    @Column(name = "date_start")
    private String date_start;

    @Column(name = "date_end")
    private String date_end;

/*    @Column(name = "type_training")
    private TypeTraining type_training;*/

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_password")
    private String password;
}
