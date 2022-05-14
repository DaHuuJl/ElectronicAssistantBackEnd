package ru.cchgeu.electronicassistantbackend.controllers;


import org.springframework.web.bind.annotation.*;
import ru.cchgeu.electronicassistantbackend.model.entity.user.TUser;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/UTest")
public class TUserController {
        private List<TUser> someTUser = List.of(
                new TUser(1, "Ken"),
                new TUser(2, "Yannick"),
                new TUser(3, "Pieter"));

    @GetMapping
    @RolesAllowed({"electronicassistant-user", "electronicassistant-admin"})
    public List<TUser> heroes() {
        return someTUser;
    }
    @GetMapping("/{id}")
    @RolesAllowed("electronicassistant-admin")
    public TUser tuser(@PathVariable("id") String id) {
        return someTUser.stream()
                .filter(h -> Integer.toString(h.getId()).equals(id))
                .findFirst()
                .orElse(null);
    }
}

