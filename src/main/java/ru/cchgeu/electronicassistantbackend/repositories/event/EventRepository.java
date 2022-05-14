package ru.cchgeu.electronicassistantbackend.repositories.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.event.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
