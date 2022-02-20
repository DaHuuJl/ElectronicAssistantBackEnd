package ru.cchgeu.electronicassistantbackend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.cchgeu.electronicassistantbackend.model.entity.user.ERole;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}