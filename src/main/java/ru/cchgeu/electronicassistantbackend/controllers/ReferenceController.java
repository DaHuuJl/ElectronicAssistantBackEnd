package ru.cchgeu.electronicassistantbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.cchgeu.electronicassistantbackend.model.dto.UserDto;
import ru.cchgeu.electronicassistantbackend.services.impl.UserReference;
import ru.cchgeu.electronicassistantbackend.utils.OperationResponse;

@RestController
@RequestMapping(value = "/api/reference",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReferenceController {

    private final UserReference userReference;

    @Autowired
    public ReferenceController(UserReference userReference) {
        this.userReference = userReference;
    }

    @RequestMapping(value = "/referenceTraining", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public OperationResponse registrationNewUser(@RequestBody UserDto user){
//        Users userEntity = UserMapper.MAPPER.toEntity(user);
        return userReference.createReferenceTraining(user);
    }
}
