package ru.cchgeu.electronicassistantbackend.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Type_training;


@Getter
@Setter
@NoArgsConstructor
public class UserReferenceDto {

    private Long id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Integer course;
    private String groupp;
    private String facultet;
    private String date_start;
    private String date_end;
    private Type_training type_training;
    private String locationsreferences;

    public String getFileName(){
        return lastName + firstName + " " + groupp;
    }

    public String getFIO(){
        return lastName + " " + firstName + " " + patronymic;
    }
}
