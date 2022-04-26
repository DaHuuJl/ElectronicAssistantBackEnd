package ru.cchgeu.electronicassistantbackend.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cchgeu.electronicassistantbackend.model.entity.study.structure.Group;
import ru.cchgeu.electronicassistantbackend.services.study.structure.GroupServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/group", produces = {MediaType.APPLICATION_JSON_VALUE})
public class GroupController {

    private final GroupServiceImpl groupServiceImpl;

    public GroupController(GroupServiceImpl groupServiceImpl) {
        this.groupServiceImpl = groupServiceImpl;
    }

    @GetMapping(path = "/findAll")
    public List<Group> findAll() {
        return groupServiceImpl.findAll();
    }

    @GetMapping(path = "/findPage")
    public Page<Group> getPage(Pageable pageable) {
        return groupServiceImpl.findPage(pageable);
    }
}
