package crinfotask.task.services.implementations;

import crinfotask.task.repositories.interfaces.EmailRepository;
import crinfotask.task.services.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public boolean isDuplicate(String email) {
        return emailRepository.isDuplicate(email);
    }

}
