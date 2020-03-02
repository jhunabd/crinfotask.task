package crinfotask.task.database;

public class PersonSqlQueries {

    public static final String REGISTER_PERSON = "INSERT INTO persons (id,full_name,birthdate,email,password,last_login) VALUES (null,:full_name ,:birthdate ," +
            ":email,:password , null )";

    public static final String GET_PERSON_BY_EMAIL = "select id,full_name,birthdate,email,password,last_login,role_id,last_login,created_on " +
            " from persons " +
            " where email = :email";

    public static final String UPDATE_LAST_LOGIN  = " update persons set last_login = CURRENT_TIMESTAMP " +
            "where email = :email ";
}
