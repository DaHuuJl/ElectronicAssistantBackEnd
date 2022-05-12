package ru.cchgeu.electronicassistantbackend.repositories.references;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Reference;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, String> {
}
