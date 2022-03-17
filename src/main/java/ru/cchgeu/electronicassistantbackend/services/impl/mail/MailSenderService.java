package ru.cchgeu.electronicassistantbackend.services.impl.mail;

public interface MailSenderService {

    void sendMessage(String email, String subject, String message);
    void sendHtmlDocument(String email, String subject, String message);
}
