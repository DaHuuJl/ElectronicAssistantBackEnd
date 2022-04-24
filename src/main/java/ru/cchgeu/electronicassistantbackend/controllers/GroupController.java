package ru.cchgeu.electronicassistantbackend.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cchgeu.electronicassistantbackend.repositories.study.structure.GroupRepository;

@RestController
@RequestMapping(value = "/api/group",produces = {MediaType.APPLICATION_JSON_VALUE})
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
