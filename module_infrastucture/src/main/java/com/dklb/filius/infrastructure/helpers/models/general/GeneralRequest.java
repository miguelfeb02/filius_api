package com.dklb.filius.infrastructure.helpers.models.general;

import java.io.Serializable;

public class GeneralRequest  {
   private Object body;


    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }


    public String generateStringJson() {
        return "{\"body\":" + body + "}";
    }
}
