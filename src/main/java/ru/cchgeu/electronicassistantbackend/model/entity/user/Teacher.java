package ru.cchgeu.electronicassistantbackend.model.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@Entity(name = "USR_TEACHER")
@NoArgsConstructor
public class Teacher {
//    @Id
//    @Column(name = "TEACHER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
