package ru.cchgeu.electronicassistantbackend.model.entity.references;

import lombok.*;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.FormatReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.StatusReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.TypeReference;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Employee;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Student;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity(name = "CNT_REFERENCES")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reference {
    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "TYPE_REFERENCE", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeReference typeReference;

    @Column(name = "FORMAT_REFERENCE", nullable = false)
    @Enumerated(EnumType.STRING)
    private FormatReference formatReference;

    @Column(name = "STATUS_REFERENCE", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusReference statusReference;

    @Column(name = "PLACE_PRESENTATION", nullable = false)
    private String placePresentation;

    @Column(name = "DATE_CREATION_REQUEST", nullable = false)
    private Date dateCreationRequest;

    @Column(name = "DATE_CREATION_REFERENCE")
    private Date dateCreationReference;
}
