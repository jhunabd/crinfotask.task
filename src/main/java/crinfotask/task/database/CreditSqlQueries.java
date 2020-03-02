package crinfotask.task.database;

public class CreditSqlQueries {

    //id(int PK)
    //person_id(int FK NOT NULL)
    //account_no(nvarchar(255) NOT NULL)
    //initial_amount(decimal(18,4) NOT NULL)
    //credit_type(int FK NOT NULL)
    //outstanding_debt(decima(18,4) NOT NULL)
    //last_payment_date(datetime)
    //contract_started_on(datetime NOT NULL)
    //contract_due_on(datetime NOT NULL)
    //created_on(datetime NOT NULL)
    //modified_on(datetime NOT NULL)

    public static final String ADD_CREDIT = "insert into credits(person_id,account_no,initial_payment,credit_type_id,outstanding_dept, " +
            " contract_started_on,contract_due_on) values(:person_id,:account_no,:initial_payment,:credit_type_id,:outstanding_debt," +
            " :contract_started_on, :contract_due_on)";


    public static final String ADD_CREDIT_HISTORY = "insert into credit_history(credit_id,person_id," +
            " report_period,account_no,initial_amount,credit_type_id," +
            " outstanding_dept,last_payment_date," +
            " contract_started_on,contract_due_on) values(:credit_id,:person_id,:report_period,:account_no,:initial_amount," +
            " :credit_type_id,:outstanding_debt,:last_payment_date," +
            " :contract_started_on, :contract_due_on)";

    public static final String GET_CREDIT_HISTORIES_BY_PERSON_ID = "select id,credit_id,person_id,report_period,account_no,initial_amount,credit_type_id,outstanding_dept, " +
            " last_payment_date,contract_started_on,contract_due_on,created_on,modified_on from credit_history " +
            " where person_id = :id";

    public static final String GET_CREDIT_HISTORY_BY_ID = "select id,credit_id,person_id,report_period,account_no,initial_amount,credit_type_id,outstanding_dept, " +
            " last_payment_date,contract_started_on,contract_due_on,created_on,modified_on from credit_history " +
            " where id = :id";

    public static final String UPDATE_CREDIT_HISTORY_BY_ID = "update credit_history  " +
            "set credit_id = :credit_id, " +
            "    person_id = :person_id, " +
            " report_period = :report_period, " +
            "    account_no = :account_no, " +
            " initial_amount = :initial_amount, " +
            "    credit_type_id = :credit_type_id, " +
            " outstanding_dept = :outstanding_dept, " +
            "    last_payment_date = :last_payment_date, " +
            "    contract_started_on = :contract_started_on, " +
            "    contract_due_on = :contract_due_on, " +
            "    created_on = :created_on, " +
            "    modified_on = current_timestamp " +
            " where id = :id ";

}
