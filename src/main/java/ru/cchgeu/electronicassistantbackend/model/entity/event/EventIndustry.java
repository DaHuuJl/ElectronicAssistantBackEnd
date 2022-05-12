package ru.cchgeu.electronicassistantbackend.model.entity.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity(name = "EVN_EVENT_INDUSTRY")
@NoArgsConstructor
public class EventIndustry {
    @Id
    @Column(name = "EVENT_INDUSTRY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "EVN_EVENT_INDUSTRY_EVENT_INDUSTRY_ID_SEQ_GEN")
    @SequenceGenerator(name = "EVN_EVENT_INDUSTRY_EVENT_INDUSTRY_ID_SEQ_GEN",
            sequenceName = "EVN_EVENT_INDUSTRY_EVENT_INDUSTRY_ID_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INDUSTRY_ID", nullable = false)
    private Industry industry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID", nullable = false)
    private Event event;
}
