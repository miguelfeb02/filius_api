package domain.models;

public class Login {
    private Boolean login;
    private String jwt;

    public Login(Boolean login, String jwt) {
        this.login = login;
        this.jwt = jwt;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
