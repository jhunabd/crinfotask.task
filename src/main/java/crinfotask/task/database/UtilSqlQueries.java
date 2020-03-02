package crinfotask.task.database;

public class UtilSqlQueries {

    public static final String GET_EMAIL_IF_EXIST = "select email from persons where " +
             " email = :email ";
}
