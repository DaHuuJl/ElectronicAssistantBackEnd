package ru.cchgeu.electronicassistantbackend.services;

public interface MailSenderService {

    public void send(String email, String subject, String message);
}
