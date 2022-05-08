package ru.cchgeu.electronicassistantbackend.services.user;

import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.repositories.user.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
