package ru.cchgeu.electronicassistantbackend.model.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Reference;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.SubjectInformation;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Department;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "USR_EMPLOYEE")
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "USR_EMPLOYEE_EMPLOYEE_ID_SEQ_GEN")
    @SequenceGenerator(name = "USR_EMPLOYEE_EMPLOYEE_ID_SEQ_GEN",
            sequenceName = "USR_EMPLOYEE_EMPLOYEE_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "POST", nullable = false)
    private String post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    private User user;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = true)
    private User user;
    */

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<SubjectInformation> subjectInformationList;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Reference> referenceList;
}
