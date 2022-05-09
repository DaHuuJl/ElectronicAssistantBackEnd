package ru.cchgeu.electronicassistantbackend.model.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SEC_USER_USER_ID_SEQ_GEN")
    @SequenceGenerator(name = "SEC_USER_USER_ID_SEQ_GEN",
            sequenceName = "SEC_USER_USER_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserPermissions> userPermissionsList;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Employee employeeVersion;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Student studentVersion;

    /*
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Employee> employeeVersion;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Student> studentVersion;
    */
}
