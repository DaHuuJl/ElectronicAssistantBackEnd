package ru.cchgeu.electronicassistantbackend.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cchgeu.electronicassistantbackend.model.dto.ReferenceRequestInput;
import ru.cchgeu.electronicassistantbackend.services.reference.ReferenceServiceImpl;

@RestController
@RequestMapping(value = "/api/reference",produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReferenceController {

    private final ReferenceServiceImpl referenceService;

    public ReferenceController(ReferenceServiceImpl referenceService) {
        this.referenceService = referenceService;
    }

    @PostMapping(path = "/createReferenceForInput")
    public ResponseEntity<Boolean> createRequestForReference(@RequestBody ReferenceRequestInput referenceRequestInput) {
        referenceService.createReferenceForInput(referenceRequestInput);
        return ResponseEntity.ok().build();
    }

/*    @PostMapping(path = "/reference-training")
    public void registrationNewReference(@RequestBody UserReferenceWorkDto userReferenceWorkDto) throws IOException, WriterException{
        referenceService.createReferenceTraining(userReferenceWorkDto);
    }

    @GetMapping("/verification")
    public Optional<User> verificationOfExistence(@RequestParam("uuid-reference") String uuidReference){
        return referenceService.verificationQRCodeReference(uuidReference);
    }*/
}
