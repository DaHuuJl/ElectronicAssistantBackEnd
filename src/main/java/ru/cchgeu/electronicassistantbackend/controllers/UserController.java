package ru.cchgeu.electronicassistantbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.cchgeu.electronicassistantbackend.services.impl.ReferenceImpl;
import ru.cchgeu.electronicassistantbackend.services.impl.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/user",produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    private final UserServiceImpl userService;
    private final ReferenceImpl referenceService;

    @Autowired
    public UserController(UserServiceImpl userService, ReferenceImpl referenceService) {
        this.userService = userService;
        this.referenceService = referenceService;
    }

/*    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody) {
        return userService
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }*/

    @RequestMapping(value = "/getNew", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser() {
        return "Новая строка";
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String check() {
        referenceService.getReference();
        return "Новая строка";
    }
}
