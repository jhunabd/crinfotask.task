package crinfotask.task.repositories.interfaces;

import crinfotask.task.domains.Credit;
import crinfotask.task.domains.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditRepository {

    Credit addCredit(Credit credit);

    CreditHistory addCreditHistory(Credit credit);

    List<CreditHistory> getCreditHistoriesByPersonId(long id);

    Optional<CreditHistory> getCreditHistoryById(long id);

    CreditHistory updateCreditHistoryById(CreditHistory creditHistory);
}
