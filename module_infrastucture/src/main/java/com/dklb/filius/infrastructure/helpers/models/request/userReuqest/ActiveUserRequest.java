package com.dklb.filius.infrastructure.helpers.models.request.userReuqest;


public class ActiveUserRequest {

    private  Boolean active;

    private String userNick;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
}
