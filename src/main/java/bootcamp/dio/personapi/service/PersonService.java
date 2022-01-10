package bootcamp.dio.personapi.service;

import bootcamp.dio.personapi.dto.MessageResponseDto;
import bootcamp.dio.personapi.entity.Person;
import bootcamp.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    public MessageResponseDto createPerson(Person person){

        Person saveperson=personRepository.save(person);
        return MessageResponseDto.builder().message("created person with ID "+saveperson.getId() ).build();
    }



}
