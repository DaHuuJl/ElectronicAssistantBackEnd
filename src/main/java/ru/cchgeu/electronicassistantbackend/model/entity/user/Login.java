package ru.cchgeu.electronicassistantbackend.model.entity.user;

import lombok.Data;

@Data
public class Login  {
    private String username = "";
    private String password = "";
}