package ru.cchgeu.electronicassistantbackend.services.user;

import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Student;
import ru.cchgeu.electronicassistantbackend.repositories.user.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
