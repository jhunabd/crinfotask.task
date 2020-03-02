package crinfotask.task.services.implementations;

import crinfotask.task.services.interfaces.PasswordService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public String hashPassword(String clearPassword) {
       return BCrypt.hashpw(clearPassword,BCrypt.gensalt());
    }

}
