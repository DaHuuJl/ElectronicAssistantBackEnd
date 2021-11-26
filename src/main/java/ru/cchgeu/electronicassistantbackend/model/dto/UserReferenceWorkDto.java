package ru.cchgeu.electronicassistantbackend.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Format_reference;
import ru.cchgeu.electronicassistantbackend.model.entity.references.Type_reference;

@Getter
@Setter
@NoArgsConstructor
public class UserReferenceWorkDto {
    private Long student_id;
    private String locationsreferences;
    private Format_reference format_reference;
    private Type_reference type_reference;
}
