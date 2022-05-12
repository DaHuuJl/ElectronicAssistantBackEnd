package ru.cchgeu.electronicassistantbackend.model.entity.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "EVN_INDUSTRY")
@NoArgsConstructor
public class Industry {
    @Id
    @Column(name = "INDUSTRY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "EVN_INDUSTRY_INDUSTRY_ID_SEQ_GEN")
    @SequenceGenerator(name = "EVN_INDUSTRY_INDUSTRY_ID_SEQ_GEN",
            sequenceName = "EVN_INDUSTRY_INDUSTRY_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @OneToMany(mappedBy = "industry", fetch = FetchType.LAZY)
    private List<EventIndustry> eventIndustryList;
}
