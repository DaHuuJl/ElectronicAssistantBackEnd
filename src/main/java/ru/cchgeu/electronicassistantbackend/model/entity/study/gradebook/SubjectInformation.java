package ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.enums.AttestationType;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.enums.PracticeType;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "STD_SUBJECT_INFORMATION")
@NoArgsConstructor
public class SubjectInformation {
    @Id
    @Column(name = "SUBJECT_INFORMATION_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "STD_SUBJECT_INFORMATION_SUBJECT_INFORMATION_ID_SEQ_GEN")
    @SequenceGenerator(name = "STD_SUBJECT_INFORMATION_SUBJECT_INFORMATION_ID_SEQ_GEN",
            sequenceName = "STD_SUBJECT_INFORMATION_SUBJECT_INFORMATION_ID_SEQ", allocationSize = 1)
    private Long id;

    //TODO: связать с преподователем
    @Column(name = "TEACHER_ID", nullable = false)
    private Long teacher;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "ATTESTATION_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private AttestationType attestationType;

    @Column(name = "ASSESSMENT", nullable = false)
    private String assessment;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @Column(name = "TOPIC")
    private String topic;

    @Column(name = "PRACTICE_TYPE")
    @Enumerated(EnumType.STRING)
    private PracticeType practiceType;

    @Column(name = "PLACE_PRACTICE")
    private String placePractice;

    @OneToMany(mappedBy ="subject", fetch = FetchType.LAZY)
    private List<SemesterInformation> semesterInformationList;
}
