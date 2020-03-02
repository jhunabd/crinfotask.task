package crinfotask.task.jwt;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 878358918173525596L;

    public AuthenticationResponse(String jwtToken) {
        this.jwt = jwtToken;
    }

    public AuthenticationResponse() {
    }

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwtToken(String jwtToken) {
        this.jwt = jwtToken;
    }
}
