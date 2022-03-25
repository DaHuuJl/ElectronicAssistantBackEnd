package ru.cchgeu.electronicassistantbackend.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.Gradebook;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Group;
import ru.cchgeu.electronicassistantbackend.model.entity.user.enums.TuitionFormType;
import ru.cchgeu.electronicassistantbackend.model.entity.user.enums.TuitionType;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "USR_STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @Column(name = "STUDENT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "USR_STUDENT_STUDENT_ID_SEQ_GEN")
    @SequenceGenerator(name = "USR_STUDENT_STUDENT_ID_SEQ_GEN",
            sequenceName = "USR_STUDENT_STUDENT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private Group group;

    @Column(name = "TUITION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TuitionType tuitionType;

    @Column(name = "TUITION_FORM_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TuitionFormType tuitionFormType;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @OneToMany(mappedBy ="student", fetch = FetchType.LAZY)
    private List<Gradebook> gradebookList;
}
