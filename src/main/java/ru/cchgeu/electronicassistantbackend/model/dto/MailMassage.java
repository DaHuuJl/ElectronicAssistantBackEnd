package ru.cchgeu.electronicassistantbackend.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MailMassage {
    private String email;
    private String subject;
    private String message;
}
