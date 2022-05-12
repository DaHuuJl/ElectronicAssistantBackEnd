package ru.cchgeu.electronicassistantbackend.model.entity.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.event.enums.EventType;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "EVN_EVENT")
@NoArgsConstructor
public class Event {

    @Id
    @Column(name = "EVENT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "EVN_EVENT_EVENT_ID_SEQ_GEN")
    @SequenceGenerator(name = "EVN_EVENT_EVENT_ID_SEQ_GEN",
            sequenceName = "EVN_EVENT_EVENT_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    //TODO: тут должна быть картинка
    @Column(name = "PREVIEW", nullable = true)
    private String preview;

    @Column(name = "EVENT_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID", nullable = false)
    private User creator;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<EventOrganizers> eventOrganizers;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<EventIndustry> eventIndustryList;
}
