package crinfotask.task.utils;

import crinfotask.task.domains.Person;
import crinfotask.task.domains.PersonDto;

public class PersonToDtoUtil {

    public static PersonDto convertPerson(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFullName(person.getFullName());
        personDto.setBirthdate(person.getBirthdate());
        personDto.setEmail(person.getEmail());
        personDto.setLastLogin(person.getLastLogin());
        return personDto;
    }
}
