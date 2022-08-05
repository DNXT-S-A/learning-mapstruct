package pt.digitalnext.mapstruct.domain.converter;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pt.digitalnext.mapstruct.domain.dto.ClientDTO;
import pt.digitalnext.mapstruct.domain.dto.PersonDTO;
import pt.digitalnext.mapstruct.domain.model.Person;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "phoneNumber", target = "phone")
    //@Mapping(target = "cc", ignore = true)
    @Mapping(source = "birthDate", target = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "biometricData.cc", target="cc")
    @Mapping(source = "biometricData.nif", target="nif")
    ClientDTO convertToDto(Person person);

    @InheritInverseConfiguration
    Person convertToModel(ClientDTO authorityDataDTO);

    @AfterMapping
    default void convertNameToUpperCase(Person person, @MappingTarget ClientDTO clientDTO) {
        clientDTO.setName(clientDTO.getName().toUpperCase());
        if(person.getCodeNumber()!= null){
            clientDTO.setPhone(person.getCodeNumber()+clientDTO.getPhone());
        }
    }

    List<ClientDTO> convertToListDto(List<Person> personList);

    List<Person> convertToListModel(List<ClientDTO> clientDTOS);

}
