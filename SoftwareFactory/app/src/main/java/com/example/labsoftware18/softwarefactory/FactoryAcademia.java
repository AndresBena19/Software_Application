package com.example.labsoftware18.softwarefactory;

/**
 * Created by andres felipe on 18/08/2017.
 */

public class FactoryAcademia {

    public static Persona Obtener (String tipo){

    if (tipo.equals("Estudiante")) {

        return new Estudiante();
    }else if (tipo.equals("Profesor")) {
        return  new Profesor();

    }else if (tipo.equals("Administrativo")) {
        return  new Administrativo();
    }
    return null;
}



}
