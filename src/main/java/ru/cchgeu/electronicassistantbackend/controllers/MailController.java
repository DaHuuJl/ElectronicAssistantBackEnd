package ru.cchgeu.electronicassistantbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cchgeu.electronicassistantbackend.model.dto.MailMassage;
import ru.cchgeu.electronicassistantbackend.services.impl.mail.MailSenderServiceImpl;
import ru.cchgeu.electronicassistantbackend.services.impl.mail.TemplateEngineServiceImpl;

/*
    TODO: Этот контроллер создан, чтобы проверить работает ли отправка сообщений, его нужно убрать в будущем
*/
@RestController@RequestMapping(value = "/api/mail/sender",produces = {MediaType.APPLICATION_JSON_VALUE})
public class MailController {

    private final MailSenderServiceImpl mailSenderService;
    private final TemplateEngineServiceImpl templateEngineService;

    @Autowired
    public MailController(MailSenderServiceImpl mailSenderService, TemplateEngineServiceImpl templateEngineService) {
        this.mailSenderService = mailSenderService;
        this.templateEngineService = templateEngineService;
    }

    @PostMapping(path = "/send")
    public void send(@RequestBody MailMassage massage) {
        mailSenderService.sendMessage(massage.getEmail(), massage.getSubject(), massage.getMessage());
    }

    @PostMapping(path = "/sendDocument")
    public void sendDocument(@RequestBody MailMassage massage) {
        mailSenderService.sendHtmlDocument(massage.getEmail(), massage.getSubject(), templateEngineService.getTestDocument(massage.getEmail(), massage.getSubject()));
    }
}
