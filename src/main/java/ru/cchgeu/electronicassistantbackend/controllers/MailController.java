package ru.cchgeu.electronicassistantbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cchgeu.electronicassistantbackend.model.dto.MailMassage;
import ru.cchgeu.electronicassistantbackend.services.impl.MailSenderServiceImpl;

@RestController@RequestMapping(value = "/api/mail/sender",produces = {MediaType.APPLICATION_JSON_VALUE})
public class MailController {

    private final MailSenderServiceImpl mailSenderService;

    @Autowired
    public MailController(MailSenderServiceImpl mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping(path = "/send")
    public void send(@RequestBody MailMassage massage) {
        mailSenderService.send(massage.getEmail(), massage.getSubject(), massage.getMessage());
    }
}
