package crinfotask.task.rowmappers;

import crinfotask.task.domains.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong("id"));
        person.setFullName(resultSet.getString("full_name"));
        person.setBirthdate(resultSet.getDate("birthdate").toLocalDate());
        person.setEmail(resultSet.getString("email"));
        person.setPassword(resultSet.getString("password"));
        person.setRoleTypeId(resultSet.getInt("role_id"));
        if(resultSet.getTimestamp("last_login") != null) {
            person.setLastLogin(resultSet.getTimestamp("last_login").toLocalDateTime());
        }
        person.setCreatedOn(resultSet.getTimestamp("created_on").toLocalDateTime());
        return person;
    }
}
