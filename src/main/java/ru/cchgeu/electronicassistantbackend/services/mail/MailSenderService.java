package ru.cchgeu.electronicassistantbackend.services.mail;

public interface MailSenderService {

    void sendMessage(String email, String subject, String message);
    void sendHtmlDocument(String email, String subject, String message);
}
