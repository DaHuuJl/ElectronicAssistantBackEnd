package ru.cchgeu.electronicassistantbackend.services.study.structure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    void save(Group group);
    void delete(Group group);
    Page<Group> findPage(Pageable pageable);
}
