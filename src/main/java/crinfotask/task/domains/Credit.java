package crinfotask.task.domains;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Credit implements Serializable {

    private static final long serialVersionUID = -7241679961787805516L;

    //id(int PK)
    //person_id(int FK NOT NULL)
    //account_no(nvarchar(255) NOT NULL)
    //initial_amount(decimal(18,4) NOT NULL)
    //credit_type(int FK NOT NULL)
    //outstanding_debt(decimal(18,4) NOT NULL)
    //last_payment_date(datetime)
    //contract_started_on(datetime NOT NULL)
    //contract_due_on(datetime NOT NULL)
    //created_on(datetime NOT NULL)
    //modified_on(datetime NOT NULL)

    private long id;

    @NotEmpty(message = "person id cannot be null")
    private long personId;

    @NotEmpty(message = "account no cannot be null")
    private String accountNo;


    @NotNull(message = "initial amount cannot be null")
    @Min(value = 1, message = "initial amount must be >1")
    private BigDecimal initialAmount;
    @NotNull(message = "you must choose credit type")
    private long creditTypeId;
    @NotNull(message = "qaliq borc gosterilmelidir")
    private BigDecimal outstandingDebt;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime lastPaymentDate;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @NotNull
    private LocalDateTime contractStartedOn;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @NotNull
    private LocalDateTime contractDueOn;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime createdOn;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime modifiedOn;

    public Credit() {
    }

    public Credit(long id,
                  long personId,
                  String accountNo,
                  BigDecimal initialAmount,
                  long creditTypeId,
                  BigDecimal outstandingDebt,
                  LocalDateTime lastPaymentDate,
                  LocalDateTime contractStartedOn,
                  LocalDateTime contractDueOn,
                  LocalDateTime createdOn,
                  LocalDateTime modifiedOn) {
        this.id = id;
        this.personId = personId;
        this.accountNo = accountNo;
        this.initialAmount = initialAmount;
        this.creditTypeId = creditTypeId;
        this.outstandingDebt = outstandingDebt;
        this.lastPaymentDate = lastPaymentDate;
        this.contractStartedOn = contractStartedOn;
        this.contractDueOn = contractDueOn;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public long getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(long creditTypeId) {
        this.creditTypeId = creditTypeId;
    }

    public BigDecimal getOutstandingDebt() {
        return outstandingDebt;
    }

    public void setOutstandingDebt(BigDecimal outstandingDebt) {
        this.outstandingDebt = outstandingDebt;
    }

    public LocalDateTime getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDateTime lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public LocalDateTime getContractStartedOn() {
        return contractStartedOn;
    }

    public void setContractStartedOn(LocalDateTime contractStartedOn) {
        this.contractStartedOn = contractStartedOn;
    }

    public LocalDateTime getContractDueOn() {
        return contractDueOn;
    }

    public void setContractDueOn(LocalDateTime contractDueOn) {
        this.contractDueOn = contractDueOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", personId=" + personId +
                ", accountNo='" + accountNo + '\'' +
                ", initialAmount=" + initialAmount +
                ", creditTypeId=" + creditTypeId +
                ", outstandingDebt=" + outstandingDebt +
                ", lastPaymentDate=" + lastPaymentDate +
                ", contractStartedOn=" + contractStartedOn +
                ", contractDueOn=" + contractDueOn +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                '}';
    }
}
