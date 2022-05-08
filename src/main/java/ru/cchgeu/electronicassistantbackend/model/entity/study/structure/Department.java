package ru.cchgeu.electronicassistantbackend.model.entity.study.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Employee;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "STR_DEPARTMENT")
@NoArgsConstructor
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "STR_DEPARTMENT_DEPARTMENT_ID_SEQ_GEN")
    @SequenceGenerator(name = "STR_DEPARTMENT_DEPARTMENT_ID_SEQ_GEN",
            sequenceName = "STR_DEPARTMENT_DEPARTMENT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
}