package crinfotask.task.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonDto implements Serializable {
    private static final long serialVersionUID = -2595920527635340694L;


    private long id;

    @JsonProperty("ad")
    private String fullName;

    @JsonProperty("dogum_gunu")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;


    private String email;

    @JsonProperty("son_daxil_olma")
    private LocalDateTime lastLogin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }


    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
