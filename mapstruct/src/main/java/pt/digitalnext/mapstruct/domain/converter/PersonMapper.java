package pt.digitalnext.mapstruct.domain.converter;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pt.digitalnext.mapstruct.domain.dto.PersonDTO;
import pt.digitalnext.mapstruct.domain.model.Person;

import java.util.List;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "phoneNumber", target = "phone")
    @Mapping(target = "username", ignore = true)
    @Mapping(source = "birthDate", target = "birthDate", dateFormat = "dd-MM-yyyy")
    PersonDTO convertToDto(Person person);

    @InheritInverseConfiguration
    Person convertToModel(PersonDTO authorityDataDTO);

    @AfterMapping
    default void convertNameToUpperCase(@MappingTarget PersonDTO personDTO) {
        personDTO.setName(personDTO.getName().toUpperCase());
    }

    List<PersonDTO> convertToListDto(List<Person> personList);

    List<Person> convertToListModel(List<PersonDTO> personDTOS);
}