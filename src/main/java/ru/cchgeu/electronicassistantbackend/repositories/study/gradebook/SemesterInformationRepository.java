package ru.cchgeu.electronicassistantbackend.repositories.study.gradebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.study.gradebook.SemesterInformation;

@Repository
public interface SemesterInformationRepository extends JpaRepository<SemesterInformation, Long> {
}