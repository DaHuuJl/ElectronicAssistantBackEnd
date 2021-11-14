package ru.cchgeu.electronicassistantbackend.controllers;


import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceDto;
import ru.cchgeu.electronicassistantbackend.services.impl.ReferenceService;
import ru.cchgeu.electronicassistantbackend.utils.OperationResponse;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/reference",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReferenceController {

    private final ReferenceService referenceService;

    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @PostMapping(path = "/reference-training")
    public OperationResponse registrationNewReference(@RequestBody UserReferenceDto user) throws IOException, WriterException, ParseException {
//       Users userEntity = UserMapper.MAPPER.toEntity(user);
        return referenceService.createReferenceTraining(user);
    }

    @GetMapping("/verification")
    public OperationResponse verificationOfExistence(@RequestParam("uuid-reference") String uuidReference){
        return referenceService.verificationQRCodeReference(uuidReference);
    }
}
