package ru.cchgeu.electronicassistantbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cchgeu.electronicassistantbackend.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
