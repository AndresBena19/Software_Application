package com.example.labsoftware18.softwarefactory;

/**
 * Created by andres felipe on 20/08/2017.
 */

public class Asistencia {

    private static final Asistencia contador=new Asistencia();
    private int Asis=0;

    private Asistencia(){}

    public static Asistencia getInstance() {
        return contador;
    }


    public void setContador(int a){
        Asis=Asis+a;
    }

    public int GetContador(){
        return Asis;
    }

}
