package ru.cchgeu.electronicassistantbackend.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Reference;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.Gradebook;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Group;
import ru.cchgeu.electronicassistantbackend.model.entity.user.enums.ConditionType;
import ru.cchgeu.electronicassistantbackend.model.entity.user.enums.TrainingLevelType;
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

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private Group group;

    @Column(name = "TUITION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TuitionType tuitionType;

    @Column(name = "TUITION_FORM_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TuitionFormType tuitionFormType;

    @Column(name = "TRAINING_LEVEL_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TrainingLevelType trainingLevelType;

    @Column(name = "CONDITION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = true)
    private User user;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = true)
    private User user;
     */

    @OneToMany(mappedBy ="student", fetch = FetchType.LAZY)
    private List<Gradebook> gradebookList;

    @OneToMany(mappedBy ="student", fetch = FetchType.LAZY)
    private List<Reference> referenceList;
}
