//package ru.cchgeu.electronicassistantbackend.controllers;
//
//
//import com.google.zxing.WriterException;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ru.cchgeu.electronicassistantbackend.model.dto.ReferenceRequestDTO;
//import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceWorkDto;
//import ru.cchgeu.electronicassistantbackend.model.entity.user.User;
//import ru.cchgeu.electronicassistantbackend.services.reference.ReferenceServiceImpl;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = "/api/reference",produces = {MediaType.APPLICATION_JSON_VALUE})
//public class ReferenceController {
//
//    private final ReferenceServiceImpl referenceService;
//
//    public ReferenceController(ReferenceServiceImpl referenceService) {
//        this.referenceService = referenceService;
//    }
//
//    @PostMapping(path = "/createRequestForReference")
//    public ResponseEntity<Boolean> createRequestForReference(@RequestBody List<ReferenceRequestDTO> referenceRequestDTOList) {
//        referenceService.createRequestForReference(referenceRequestDTOList);
//        return ResponseEntity.ok(true);
//    }
//
//    @GetMapping("/months")
//    public List<String> welcomePage() {
//        return Arrays.asList("December", "January", "February");
//    }
//
//    @GetMapping("/admin")
//    public String adminPage() {
//        return "Admin page";
//    }
///*    @PostMapping(path = "/reference-training")
//    public void registrationNewReference(@RequestBody UserReferenceWorkDto userReferenceWorkDto) throws IOException, WriterException{
//        referenceService.createReferenceTraining(userReferenceWorkDto);
//    }
//
//    @GetMapping("/verification")
//    public Optional<User> verificationOfExistence(@RequestParam("uuid-reference") String uuidReference){
//        return referenceService.verificationQRCodeReference(uuidReference);
//    }*/
//}
