package ru.cchgeu.electronicassistantbackend.services.user;

import ru.cchgeu.electronicassistantbackend.model.entity.user.Student;

public interface StudentService {
    Student findById(Long id);
}
