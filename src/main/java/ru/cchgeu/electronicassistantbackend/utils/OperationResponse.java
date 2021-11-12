package ru.cchgeu.electronicassistantbackend.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OperationResponse {

    private String message;

    public OperationResponse(String message) {
        this.message = message;
    }
}
