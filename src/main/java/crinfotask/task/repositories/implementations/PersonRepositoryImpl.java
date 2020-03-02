package crinfotask.task.repositories.implementations;

import crinfotask.task.database.PersonSqlQueries;
import crinfotask.task.domains.Person;
import crinfotask.task.repositories.interfaces.PersonRepository;
import crinfotask.task.rowmappers.PersonRowMapper;
import crinfotask.task.services.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository  {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PersonRowMapper personRowMapper;

    @Override
    public Person registerPerson(Person person) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("full_name",person.getFullName());
        source.addValue("birthdate",person.getBirthdate());
        if(emailService.isDuplicate(person.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"email is already exist");
        }else{
            source.addValue("email",person.getEmail());
        }

        source.addValue("password",person.getPassword());
        int count = jdbcTemplate.update(PersonSqlQueries.REGISTER_PERSON,source);
        if(count > 0){
            return person;
        }else{
           throw new RuntimeException("Person elave edile bilmedi");
        }
    }

    @Override
    public Optional<Person> getPersonByEmail(String email) {
        MapSqlParameterSource source = new MapSqlParameterSource("email",email);
        Optional<Person> optionalPerson = Optional.of(jdbcTemplate.query(PersonSqlQueries.GET_PERSON_BY_EMAIL,source,personRowMapper).get(0));
        return optionalPerson;
    }

    @Override
    public int updateLastLogin(String username) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("email",username);
        return jdbcTemplate.update(PersonSqlQueries.UPDATE_LAST_LOGIN,source);
    }
}
