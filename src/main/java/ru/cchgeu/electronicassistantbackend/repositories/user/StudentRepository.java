package ru.cchgeu.electronicassistantbackend.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
