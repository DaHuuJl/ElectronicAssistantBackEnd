package ru.cchgeu.electronicassistantbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Reference;

public interface ReferenceRepository extends JpaRepository<Reference, String> {
}
