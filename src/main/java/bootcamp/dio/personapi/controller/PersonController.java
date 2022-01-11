package bootcamp.dio.personapi.controller;

import bootcamp.dio.personapi.dto.MessageResponseDto;
import bootcamp.dio.personapi.entity.Person;
import bootcamp.dio.personapi.exception.PersonNotFoundException;
import bootcamp.dio.personapi.repository.PersonRepository;
import bootcamp.dio.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @___(@Autowired))
public class PersonController {
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> listall() {
        return personService.listall();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDto updateById(@PathVariable Long id,@RequestBody Person person) throws PersonNotFoundException{
        return personService.updateById(id,person);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException{

        personService.delete(id);
    }
}
