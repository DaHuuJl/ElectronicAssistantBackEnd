package ru.cchgeu.electronicassistantbackend.model.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.SubjectInformation;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "USR_TEACHER")
@NoArgsConstructor
public class Teacher {
    @Id
    @Column(name = "TEACHER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "USR_TEACHER_TEACHER_ID_SEQ_GEN")
    @SequenceGenerator(name = "USR_TEACHER_TEACHER_ID_SEQ_GEN",
            sequenceName = "USR_TEACHER_TEACHER_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @OneToMany(mappedBy ="teacher", fetch = FetchType.LAZY)
    private List<SubjectInformation> subjectInformationList;
}
