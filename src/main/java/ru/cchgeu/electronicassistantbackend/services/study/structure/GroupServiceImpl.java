package ru.cchgeu.electronicassistantbackend.services.study.structure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Group;
import ru.cchgeu.electronicassistantbackend.repositories.study.structure.GroupRepository;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public Page<Group> findPage(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }
}
