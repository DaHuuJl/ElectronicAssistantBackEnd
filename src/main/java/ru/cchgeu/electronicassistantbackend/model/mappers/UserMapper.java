package ru.cchgeu.electronicassistantbackend.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cchgeu.electronicassistantbackend.model.dto.UserReferenceDto;
import ru.cchgeu.electronicassistantbackend.model.entity.user.Users;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<Users, UserReferenceDto> {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "userName", source = "name")
    Users toEntity(UserReferenceDto dto);

    @Mapping(target = "name", source = "userName")
    UserReferenceDto toDto(Users user);
}
