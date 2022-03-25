package ru.cchgeu.electronicassistantbackend.model.entity.study.structure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "STR_FACULTY")
@NoArgsConstructor
public class Faculty {
    @Id
    @Column(name = "FACULTY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "STR_FACULTY_FACULTY_ID_SEQ_GEN")
    @SequenceGenerator(name = "STR_FACULTY_FACULTY_ID_SEQ_GEN",
            sequenceName = "STR_FACULTY_FACULTY_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ABBREVIATION")
    private String abbreviation;

    @OneToMany(mappedBy ="faculty", fetch = FetchType.LAZY)
    private List<Department> departmentList;
}
