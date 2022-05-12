package ru.cchgeu.electronicassistantbackend.repositories.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.event.Industry;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Long> {
}
