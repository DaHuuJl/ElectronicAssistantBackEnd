package ru.cchgeu.electronicassistantbackend.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.references.FormatReference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.TypeReference;

@Getter
@Setter
@NoArgsConstructor
public class UserReferenceWorkDto {
    private Long student_id;
    private String locationsreferences;
    private FormatReference format_reference;
    private TypeReference type_reference;
}
