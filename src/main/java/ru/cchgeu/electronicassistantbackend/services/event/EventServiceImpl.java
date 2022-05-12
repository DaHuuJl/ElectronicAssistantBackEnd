package ru.cchgeu.electronicassistantbackend.services.event;

import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.repositories.event.EventRepository;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
}
