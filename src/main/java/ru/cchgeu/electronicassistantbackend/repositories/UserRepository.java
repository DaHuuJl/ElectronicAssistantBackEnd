package ru.cchgeu.electronicassistantbackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
