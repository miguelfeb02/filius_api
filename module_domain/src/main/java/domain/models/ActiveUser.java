package domain.models;

public class ActiveUser {
    String userNick;
    Boolean active;

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean estado) {
        this.active = estado;
    }
}
