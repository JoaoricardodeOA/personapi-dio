package bootcamp.dio.personapi.service;

import bootcamp.dio.personapi.dto.MessageResponseDto;
import bootcamp.dio.personapi.entity.Person;
import bootcamp.dio.personapi.exception.PersonNotFoundException;
import bootcamp.dio.personapi.mappers.PersonMapper;
import bootcamp.dio.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @___(@Autowired))
public class PersonService {
    private PersonRepository personRepository;

    public MessageResponseDto createPerson(Person person){

        Person saveperson=personRepository.save(person);
        return createMessageResponse(saveperson.getId(),"Created person with ID ");
    }


    public List<Person> listall() {
        List<Person> allPeople=personRepository.findAll();
        return allPeople;
    }

    public Person findById(Long id)  throws PersonNotFoundException{
        Person person= verifyIfExists(id);
        return person;
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }
    private Person verifyIfExists(Long id)throws PersonNotFoundException{
        return personRepository
                .findById(id).orElseThrow(()->new PersonNotFoundException(id));
    }

    public MessageResponseDto updateById(Long id, Person person) throws PersonNotFoundException{
        verifyIfExists(id);
        Person personToUpdate=personRepository.save(person);
        return createMessageResponse(id, "Updated person with ID ");
    }

    private MessageResponseDto createMessageResponse(Long id, String s) {
        return MessageResponseDto
                .builder()
                .message(s + id)
                .build();
    }
}
