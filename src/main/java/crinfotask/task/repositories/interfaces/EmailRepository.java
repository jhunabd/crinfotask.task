package crinfotask.task.repositories.interfaces;

public interface EmailRepository {
    boolean isDuplicate(String email);
}
