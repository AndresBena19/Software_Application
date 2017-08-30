# Software_Application #


# Metodo factory 
En diseño de software, el patrón de diseño Factory Method consiste en utilizar una clase constructora (al estilo del Abstract Factory) abstracta con unos cuantos métodos definidos y otro(s) abstracto(s): el dedicado a la construcción de objetos de un subtipo de un tipo determinado. Es una simplificación del Abstract Factory, en la que la clase abstracta tiene métodos concretos que usan algunos de los abstractos; según usemos una u otra hija de esta clase abstracta, tendremos uno u otro comportamiento.


```

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

``` 

En este caso, tenemos la clase factory academia, en la cual tenemos un unico metodo Getter llamado, **Obtener()**, que nos permite atravez de una entrada determinada, retornar un objeto de tipo, Estudiante, Profesor, Administrativo.

Esta 3 clases, heredan de la clase padre persona 
``` 
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
``` 


La clase persona es contenedora de un metodo abstracto **(Settipo(String T);)**, lo que obliga a la clase a ser abstracta y ademas  utilizar por obligacion en cada clase que herede el metodo, ya que el valor de este metodo Setter, sera el encargado de definir de que tipo de objeto retorna la clase FactoryAcademia()

Ejemplo de esto, en la clase Estudiante
``` 
public class Estudiante extends Persona  {


    public  void  Settipo(String T){
        this.tipo=T;
    }
}

``` 

Gracias a esto, es posible hacer uso del patron de diseño factory, para que nuestra App, retorne un tipo de objeto  dependiendo del valor de entrada
