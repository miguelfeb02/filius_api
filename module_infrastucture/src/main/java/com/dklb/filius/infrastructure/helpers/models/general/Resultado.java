package com.dklb.filius.infrastructure.helpers.models.general;

import lombok.Data;

@Data
public class Resultado {
    public String mensaje;
    public Object respuesta;
    public String code;
    public Object errores;

}
