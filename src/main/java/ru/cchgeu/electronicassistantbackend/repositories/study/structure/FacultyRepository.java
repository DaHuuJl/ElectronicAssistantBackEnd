package ru.cchgeu.electronicassistantbackend.repositories.study.structure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
