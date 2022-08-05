package pt.digitalnext.mapstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.digitalnext.mapstruct.domain.converter.ClientMapper;
import pt.digitalnext.mapstruct.domain.dto.ClientDTO;
import pt.digitalnext.mapstruct.domain.dto.PersonDTO;
import pt.digitalnext.mapstruct.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/addPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPerson(@RequestBody PersonDTO personDTO)  {
        this.personService.addPerson(personDTO);
    }

    @GetMapping(value = "/getPerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> getPersons(){
        return this.personService.getPersons();
    }

    @GetMapping(value = "/addData", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addData(){
        this.personService.addData();
    }

    @PostMapping(value = "/getClient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO getClient(@RequestBody String username){
        return this.personService.getClient(username);
    }

    @PostMapping(value = "/addClient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClient(@RequestBody ClientDTO clientDTO)  {
        this.personService.addClient(clientDTO);
    }

    @GetMapping(value = "/getAllClients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTO> getAllClients(){
        return this.personService.getAllClients();
    }

}
