package crinfotask.task.domains;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CreditHistory implements Serializable {

    private static final long serialVersionUID = -6662288793863613051L;
    private Credit credit;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private LocalDateTime reportPeriod;

    public CreditHistory(Credit credit,LocalDateTime reportPeriod) {
        this.credit = credit;
        this.reportPeriod = reportPeriod;
    }

    public CreditHistory(Credit credit) {
        this.credit = credit;
    }

    public Credit getCredit() {
        return credit;
    }

    public LocalDateTime getReportPeriod() {
        return reportPeriod;
    }

    public void setReportPeriod(LocalDateTime reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    @Override
    public String toString() {
        return "CreditHistory{" +
                "credit=" + credit +
                ", id=" + id +
                ", reportPeriod=" + reportPeriod +
                '}';
    }
}
