package ru.cchgeu.electronicassistantbackend.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
