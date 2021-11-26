package ru.cchgeu.electronicassistantbackend.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceDto;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserReferenceDto dto);

    UserReferenceDto toDto(User user);
}
