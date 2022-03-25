package ru.cchgeu.electronicassistantbackend.services.mail;

public interface TemplateEngineService {

    String getTestDocument(String email, String subject);
}
