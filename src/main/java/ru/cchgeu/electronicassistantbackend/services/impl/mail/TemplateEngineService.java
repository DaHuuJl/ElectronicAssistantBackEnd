package ru.cchgeu.electronicassistantbackend.services.impl.mail;

public interface TemplateEngineService {

    String getTestDocument(String email, String subject);
}
