package crinfotask.task.services.implementations;

import crinfotask.task.domains.Credit;
import crinfotask.task.domains.CreditHistory;
import crinfotask.task.repositories.interfaces.CreditRepository;
import crinfotask.task.services.interfaces.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    @Transactional
    public Credit addCredit(Credit credit) {
        credit = creditRepository.addCredit(credit);
        creditRepository.addCreditHistory(credit);
        return credit;
    }

    @Override
    public CreditHistory addCreditHistory(Credit credit) {
        return creditRepository.addCreditHistory(credit);
    }

    @Override
    public List<CreditHistory> getCreditHistoriesByPersonId(long id) {
        return creditRepository.getCreditHistoriesByPersonId(id);
    }

    @Override
    public Optional<CreditHistory> getCreditHistoryById(long id) {
        return creditRepository.getCreditHistoryById(id);
    }

    @Override
    public CreditHistory updateCreditHistoryById(CreditHistory creditHistory) {
        return creditRepository.updateCreditHistoryById(creditHistory);
    }
}
