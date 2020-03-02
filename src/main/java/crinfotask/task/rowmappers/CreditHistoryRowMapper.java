package crinfotask.task.rowmappers;

import crinfotask.task.domains.Credit;
import crinfotask.task.domains.CreditHistory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CreditHistoryRowMapper implements RowMapper<CreditHistory> {

    @Override
    public CreditHistory mapRow(ResultSet resultSet, int i) throws SQLException {
        Credit credit = new Credit();
        credit.setId(resultSet.getLong("credit_id"));
        credit.setPersonId(resultSet.getLong("person_id"));
        credit.setAccountNo(resultSet.getString("account_no"));
        credit.setInitialAmount(resultSet.getBigDecimal("initial_amount"));
        credit.setCreditTypeId(resultSet.getInt("credit_type_id"));
        credit.setOutstandingDebt(resultSet.getBigDecimal("outstanding_dept"));
        if(resultSet.getTimestamp("last_payment_date") != null) {
            credit.setLastPaymentDate(resultSet.getTimestamp("last_payment_date").toLocalDateTime());
        }
        credit.setContractStartedOn(resultSet.getTimestamp("contract_started_on").toLocalDateTime());
        credit.setContractDueOn(resultSet.getTimestamp("contract_due_on").toLocalDateTime());
        credit.setCreatedOn(resultSet.getTimestamp("created_on").toLocalDateTime());
        credit.setModifiedOn(resultSet.getTimestamp("modified_on").toLocalDateTime());
        CreditHistory creditHistory = new CreditHistory(credit);
        creditHistory.setId(resultSet.getLong("id"));
        creditHistory.setReportPeriod(resultSet.getTimestamp("report_period").toLocalDateTime());

        return creditHistory;
    }
}
