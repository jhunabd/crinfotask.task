package crinfotask.task.repositories.implementations;

import crinfotask.task.database.UtilSqlQueries;
import crinfotask.task.repositories.interfaces.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryImpl implements EmailRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public boolean isDuplicate(String email) {
        if(jdbcTemplate.queryForList(UtilSqlQueries.GET_EMAIL_IF_EXIST,new MapSqlParameterSource("email",email)).size() > 0){
            return true;
        }
        return false;
    }
}
