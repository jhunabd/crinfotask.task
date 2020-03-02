package crinfotask.task.security;

import crinfotask.task.domains.Person;
import crinfotask.task.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class PersonDetailService implements UserDetailsService {

    @Autowired
    private PersonService personService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> personOptional = personService.getPersonByEmail(email);
        if(personOptional.isPresent()){
            Person person = personOptional.get();
            PersonDetails personDetails = new PersonDetails(person);
            return personDetails;
        }else{
            throw new UsernameNotFoundException("username with "+email+ " not found");
        }
    }
}
