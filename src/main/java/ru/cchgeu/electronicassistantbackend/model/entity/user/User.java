package ru.cchgeu.electronicassistantbackend.model.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.event.Event;
import ru.cchgeu.electronicassistantbackend.model.entity.event.EventOrganizers;
import ru.cchgeu.electronicassistantbackend.model.entity.security.UserPermissions;
import ru.cchgeu.electronicassistantbackend.model.entity.user.enums.Role;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "SEC_USER")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SEC_USER_USER_ID_SEQ_GEN")
    @SequenceGenerator(name = "SEC_USER_USER_ID_SEQ_GEN",
            sequenceName = "SEC_USER_USER_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "PATRONYMIC", nullable = false)
    private String patronymic;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Employee employeeVersion;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Student studentVersion;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserPermissions> userPermissionsList;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Event> eventList;

    @OneToMany(mappedBy = "organizer", fetch = FetchType.LAZY)
    private List<EventOrganizers> eventOrganizers;
    /*
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Employee> employeeVersion;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Student> studentVersion;
    */
}
