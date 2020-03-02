package crinfotask.task.services.interfaces;

import crinfotask.task.domains.Person;

import java.util.Optional;

public interface PersonService {

    Person registerPerson(Person person);
    Optional<Person> getPersonByEmail(String email);
    int updateLastLogin(String username);
}
