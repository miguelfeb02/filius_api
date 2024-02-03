package domain.models;

import domain.enums.RoleEnum;
import java.time.LocalDateTime;

public class User {
    private String userId;
    private String userNick;
    private String pass;
    private String businessId;
    private String name;
    private String email;
    private RoleEnum role;
    private Boolean active;
    private LocalDateTime dateCreated;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserNick() {return userNick;}

    public void setUserNick(String userNick) {this.userNick = userNick;}

    public String getPass() {return pass;}

    public void setPass(String pass) {this.pass = pass;}
}
