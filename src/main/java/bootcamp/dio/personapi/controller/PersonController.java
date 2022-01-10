package bootcamp.dio.personapi.controller;

import bootcamp.dio.personapi.dto.MessageResponseDto;
import bootcamp.dio.personapi.entity.Person;
import bootcamp.dio.personapi.repository.PersonRepository;
import bootcamp.dio.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
