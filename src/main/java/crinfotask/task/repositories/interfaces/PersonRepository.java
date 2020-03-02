package crinfotask.task.repositories.interfaces;

import crinfotask.task.domains.Person;

import java.util.Optional;

public interface PersonRepository {
    Person registerPerson(Person person);
    Optional<Person> getPersonByEmail(String email);
    int updateLastLogin(String username);
}
