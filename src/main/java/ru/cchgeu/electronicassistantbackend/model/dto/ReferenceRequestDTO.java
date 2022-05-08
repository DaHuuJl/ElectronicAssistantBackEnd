package ru.cchgeu.electronicassistantbackend.model.dto;

import lombok.Data;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.FormatReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.enums.TypeReference;

@Data
public class ReferenceRequestDTO {
    private FormatReference formatReference;
    private TypeReference typeReference;
    private String placePresentation;
}
