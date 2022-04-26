package ru.cchgeu.electronicassistantbackend.model.entity.study.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Student;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "STR_GROUP")
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @Column(name = "GROUP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "STR_GROUP_GROUP_ID_SEQ_GEN")
    @SequenceGenerator(name = "STR_GROUP_GROUP_ID_SEQ_GEN",
            sequenceName = "STR_GROUP_GROUP_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACULTY_ID", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy ="group", fetch = FetchType.LAZY)
    private List<Student> studentList;
}
