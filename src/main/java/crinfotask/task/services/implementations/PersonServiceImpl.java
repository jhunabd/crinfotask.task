package crinfotask.task.services.implementations;

import crinfotask.task.domains.Person;
import crinfotask.task.repositories.interfaces.PersonRepository;
import crinfotask.task.services.interfaces.PasswordService;
import crinfotask.task.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public Person registerPerson(Person person) {
        // hashing password
        person.setPassword(passwordService.hashPassword(person.getPassword()));
        return personRepository.registerPerson(person);
    }

    @Override
    public Optional<Person> getPersonByEmail(String email) {
        return personRepository.getPersonByEmail(email);
    }

    @Override
    public int updateLastLogin(String username) {
        return personRepository.updateLastLogin(username);
    }
}
