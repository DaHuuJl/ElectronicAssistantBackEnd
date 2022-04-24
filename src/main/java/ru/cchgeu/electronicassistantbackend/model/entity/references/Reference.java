package ru.cchgeu.electronicassistantbackend.model.entity.references;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.FormatReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.StatusReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.TypeReference;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "CNT_REFERENCES")
@AllArgsConstructor
public class Reference {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(nullable = false)
    private Long student_id;

    private Long employee_id;

    @Enumerated(EnumType.STRING)
    private TypeReference type_reference;

    @Column(nullable = false)
    private LocalDate date_creation;

    @Enumerated(EnumType.STRING)
    private FormatReference format_reference;

    @Enumerated(EnumType.STRING)
    private StatusReference status_reference;


    public Reference(String uuid, Long id, StatusReference ready, LocalDate dateCreating, TypeReference work, FormatReference electronic) {
        this.id = uuid;
        this.student_id = id;
        this.type_reference = work;
        this.date_creation = dateCreating;
        this.format_reference = electronic;
        this.status_reference = ready;
    }

    public Reference() {

    }
}
