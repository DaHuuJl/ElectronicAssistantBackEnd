package ru.cchgeu.electronicassistantbackend.controllers;


import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceDto;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceWorkDto;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;
import ru.cchgeu.electronicassistantbackend.services.impl.ReferenceService;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/reference",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReferenceController {

    private final ReferenceService referenceService;

    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @PostMapping(path = "/reference-training")
    public void registrationNewReference(@RequestBody UserReferenceWorkDto userReferenceWorkDto) throws IOException, WriterException{
        referenceService.createReferenceTraining(userReferenceWorkDto);
    }

    @GetMapping("/verification")
    public Optional<User> verificationOfExistence(@RequestParam("uuid-reference") String uuidReference){
        return referenceService.verificationQRCodeReference(uuidReference);
    }
}
