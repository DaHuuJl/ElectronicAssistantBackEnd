package ru.cchgeu.electronicassistantbackend.repositories.study.gradebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.Gradebook;

@Repository
public interface GradebookRepository extends JpaRepository<Gradebook, Long> {
}
