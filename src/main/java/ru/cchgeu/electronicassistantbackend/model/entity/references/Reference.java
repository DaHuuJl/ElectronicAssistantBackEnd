package ru.cchgeu.electronicassistantbackend.model.entity.references;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "reference")
@AllArgsConstructor
public class Reference {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(nullable = false)
    private Long student_id;

    private Long employee_id;

    @Enumerated(EnumType.STRING)
    private Type_reference type_reference;

    @Column(nullable = false)
    private Date date_creation;

    @Enumerated(EnumType.STRING)
    private Format_reference format_reference;

    @Enumerated(EnumType.STRING)
    private Status_reference status_reference;


    public Reference(String uuid, Long id, Status_reference ready, Date dateCreating, Type_reference work, Format_reference electronic) {
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
