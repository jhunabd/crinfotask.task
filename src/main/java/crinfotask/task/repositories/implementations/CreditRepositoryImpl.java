package crinfotask.task.repositories.implementations;

import crinfotask.task.database.CreditSqlQueries;
import crinfotask.task.domains.Credit;
import crinfotask.task.domains.CreditHistory;
import crinfotask.task.repositories.interfaces.CreditRepository;
import crinfotask.task.rowmappers.CreditHistoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CreditRepositoryImpl implements CreditRepository{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private CreditHistoryRowMapper creditHistoryRowMapper;


    @Override
    public Credit addCredit(Credit credit) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        KeyHolder generatedKey = new GeneratedKeyHolder();
        source.addValue("person_id",credit.getPersonId());
        source.addValue("account_no", credit.getAccountNo());
        source.addValue("initial_payment",credit.getInitialAmount());
        source.addValue("credit_type_id",credit.getCreditTypeId());
        source.addValue("outstanding_debt",credit.getOutstandingDebt());
        source.addValue("contract_started_on",credit.getContractStartedOn());
        source.addValue("contract_due_on",credit.getContractDueOn());

        int count = jdbcTemplate.update(CreditSqlQueries.ADD_CREDIT,source,generatedKey);
        if(count > 0){
            credit.setId(generatedKey.getKey().longValue());
        }
            return credit;
    }


    @Override
    public CreditHistory addCreditHistory(Credit credit) {
        CreditHistory creditHistory = new CreditHistory(credit, LocalDateTime.now());
        MapSqlParameterSource source = addValuesToSource(creditHistory);
        KeyHolder generatedKey = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(CreditSqlQueries.ADD_CREDIT_HISTORY,source,generatedKey);
        if(count > 0) {
            creditHistory.setId(generatedKey.getKey().longValue());
        }
        return creditHistory;
    }

    @Override
    public List<CreditHistory> getCreditHistoriesByPersonId(long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id",id);
        return jdbcTemplate.query(CreditSqlQueries.GET_CREDIT_HISTORIES_BY_PERSON_ID,source,creditHistoryRowMapper);
    }

    @Override
    public Optional<CreditHistory> getCreditHistoryById(long id) {
        MapSqlParameterSource source = new MapSqlParameterSource("id",id);
        Optional<CreditHistory> optionalCreditHistory = Optional.of(jdbcTemplate.query(CreditSqlQueries.GET_CREDIT_HISTORY_BY_ID,source,creditHistoryRowMapper).get(0));
        return optionalCreditHistory;
    }


    @Override
    public CreditHistory updateCreditHistoryById(CreditHistory creditHistory) {
        MapSqlParameterSource source = addValuesToSource(creditHistory);
        int count = jdbcTemplate.update(CreditSqlQueries.UPDATE_CREDIT_HISTORY_BY_ID,source);
        System.out.println(count);
        if(count > 0){
            System.out.println("succesfull");
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"cannot update");
        }
        return creditHistory;
    }


    private MapSqlParameterSource addValuesToSource(CreditHistory creditHistory){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id",creditHistory.getId());
        source.addValue("credit_id",creditHistory.getCredit().getId());
        source.addValue("person_id", creditHistory.getCredit().getPersonId());
        source.addValue("report_period", creditHistory.getReportPeriod());
        source.addValue("account_no", creditHistory.getCredit().getAccountNo());
        source.addValue("initial_amount", creditHistory.getCredit().getInitialAmount());
        source.addValue("credit_type_id", creditHistory.getCredit().getCreditTypeId());
        source.addValue("outstanding_dept", creditHistory.getCredit().getOutstandingDebt());
        source.addValue("last_payment_date", creditHistory.getCredit().getLastPaymentDate());
        source.addValue("contract_started_on",creditHistory.getCredit().getContractStartedOn());
        source.addValue("contract_due_on",creditHistory.getCredit().getContractDueOn());
        source.addValue("created_on", creditHistory.getCredit().getCreatedOn());
        return source;
    }
}
