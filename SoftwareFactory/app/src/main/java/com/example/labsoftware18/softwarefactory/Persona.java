package com.example.labsoftware18.softwarefactory;

/**
 * Created by andres felipe on 18/08/2017.
 */

public abstract class  Persona {

    public String nombre;
    private String edad;
    public String tipo;
    private String ID;

    public void   Setname(String nombre){
        this.nombre=nombre;
    }
    public String Getname(){return nombre;}

    public void   Setedad(String edad){
        this.edad=edad;
    }
    public String Getedad(){return edad;}

    public void   SetID(String ID){
        this.ID=ID;
    }
    public String GetID(){return ID;}

    public abstract  void  Settipo(String T);//Metodo que todas las clases deben implementar
    public String Gettipo(){
        return tipo;
    }


}
