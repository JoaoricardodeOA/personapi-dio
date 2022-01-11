package bootcamp.dio.personapi.mappers;

import bootcamp.dio.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    @Mapping(target = "birthDate", source ="birthDate", dataFormat= "dd-mm-yyyy")
    Person toModel(Person  person);

}
