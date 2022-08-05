package pt.digitalnext.mapstruct.service;

import org.springframework.stereotype.Service;
import pt.digitalnext.mapstruct.domain.converter.ClientMapper;
import pt.digitalnext.mapstruct.domain.converter.PersonMapper;
import pt.digitalnext.mapstruct.domain.dto.ClientDTO;
import pt.digitalnext.mapstruct.domain.dto.PersonDTO;
import pt.digitalnext.mapstruct.domain.model.BiometricData;
import pt.digitalnext.mapstruct.domain.model.Person;
import pt.digitalnext.mapstruct.repository.BiometricRepository;
import pt.digitalnext.mapstruct.repository.PersonRepository;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private BiometricRepository biometricRepository;

    public PersonService(PersonRepository personRepository, BiometricRepository biometricRepository) {
        this.personRepository = personRepository;
        this.biometricRepository = biometricRepository;
    }

    public void addPerson(PersonDTO personDTO){
        this.personRepository.save(PersonMapper.INSTANCE.convertToModel(personDTO));
    }

    public List<PersonDTO> getPersons() {
        return PersonMapper.INSTANCE.convertToListDto(this.personRepository.findAll());
    }

    public void addData() {
        BiometricData biometricData = new BiometricData();
        biometricData.setCc("123456");
        biometricData.setNif("264232123");
        biometricData = this.biometricRepository.save(biometricData);
        Person person = new Person();
        person.setBirthDate(new Date());
        person.setName("Luis");
        person.setUsername("luis");
        person.setPhoneNumber("917823212");
        person.setCodeNumber("+351");
        person.setBiometricData(biometricData);
        this.personRepository.save(person);
    }

    public ClientDTO getClient(String username) {
        Person person = this.personRepository.findByUsername(username);
        return ClientMapper.INSTANCE.convertToDto(person);
    }

    public List<ClientDTO> getAllClients() {
        List<Person> personList = this.personRepository.findAll();
        return ClientMapper.INSTANCE.convertToListDto(personList);
    }

    public void addClient(ClientDTO clientDTO) {
        this.personRepository.save(ClientMapper.INSTANCE.convertToModel(clientDTO));
    }
}
