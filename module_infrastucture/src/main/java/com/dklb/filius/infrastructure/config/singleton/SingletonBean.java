package com.dklb.filius.infrastructure.config.singleton;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class SingletonBean {

    public SingletonBean() {

    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    private String businessId;




}