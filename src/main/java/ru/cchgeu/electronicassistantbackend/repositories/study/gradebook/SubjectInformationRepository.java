package ru.cchgeu.electronicassistantbackend.repositories.study.gradebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.SubjectInformation;

@Repository
public interface SubjectInformationRepository extends JpaRepository<SubjectInformation, Long> {
}
