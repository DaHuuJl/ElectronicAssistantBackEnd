package ru.cchgeu.electronicassistantbackend.model.entity.event;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "EVN_EVENT_ORGANIZERS")
@NoArgsConstructor
public class EventOrganizers {
    @Id
    @Column(name = "EVENT_ORGANIZERS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "EVN_EVENT_ORGANIZERS_EVENT_ORGANIZERS_ID_SEQ_GEN")
    @SequenceGenerator(name = "EVN_EVENT_ORGANIZERS_EVENT_ORGANIZERS_ID_SEQ_GEN",
            sequenceName = "EVN_EVENT_ORGANIZERS_EVENT_ORGANIZERS_ID_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENT_ID", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORGANIZER_ID", nullable = false)
    private User organizer;
}
