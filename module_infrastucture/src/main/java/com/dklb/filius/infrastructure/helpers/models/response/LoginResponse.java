package com.dklb.filius.infrastructure.helpers.models.response;



public class LoginResponse {
    private Boolean login;
    private String jwt;

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
