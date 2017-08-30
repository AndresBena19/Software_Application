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

En este caso, tenemos la clase **FactoryAcademia**, en la cual tenemos un unico metodo Getter llamado, **Obtener()**, que nos permite atravez de una entrada determinada, retornar un objeto de tipo, Estudiante, Profesor, Administrativo.

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




# Metodo Singleton #



El patrón singleton se implementa creando en nuestra clase un método que crea una instancia del objeto sólo si todavía no existe alguna. Para asegurar que la clase no puede ser instanciada nuevamente se regula el alcance del constructor (con modificadores de acceso como protegido o privado).

El patrón singleton provee una única instancia global gracias a que:
 * La propia clase es responsable de crear la única instancia.
 * Permite el acceso global a dicha instancia mediante un método de clase.
 * Declara el constructor de clase como privado para que no sea instanciable directamente.
 * Al estar internamente autoreferenciada, en lenguajes como Java, el recolector de basura no actúa.
 
 ```
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
 ``` 
 
Para hacer uno del metodo singleton tenemos la clase **Asistencia** en la cual definimos y contruimos un objeto, estatico, final y con el modificador de acceso  privada, llamado **contador**, esto se hace con el fin de que  necesario poner la clase delante del metodo al intanciarlo, que no sea posible declarar un objeto con el mismo nombre en otras clases que hereden y que otras clases no tengan acceso al metodo, respectivamente.

Tambien tenemos el contructor por defecto con el modificardor de acceso privado y consigo 3 metodos.

 * SetContador(int a)
 * GetContador()
 * GetInstance()
 
 **GetContador()**, es el metodo Getter encargado de retornarnos el valor que tiene la variable privada **Asis**
 **SetContador(int a)**, es el metodo Setter encargado de recibir el valor que se asumira como unidad de asistencia, 
 
 
 los 3 anteriores el metodo **GetIntandes()** Cumple un papel fundamental, ya que este es el metodo encargado de retornar el objeto **contador** instanciado anteriormente en la clase.
 
 Lo que se busca con esto, es que al momento de instanciar un objeto de tipo asistencia, se este instanciando al mismo objeto **contador**, no importa las veces que se intancien siempre  se hara referencia a el objeto intanciado en la clase Asistencia
 
 
 Esto lo vemos implementado en el MainActivity
 

  ``` 
   Persona A= FactoryAcademia.Obtener("Estudiante");
                Asistencia Cont= Asistencia.getInstance();
                Cont.setContador(1);
   ``` 
 * Instanciamos un objeto de tipo estudiante
 * Instanciamos un  objeto de tipo Asistencia y le pasamos "1", a su metodo setter
 
 
   ``` 
   Persona A=  FactoryAcademia.Obtener("Profesor");
                Asistencia Cont= Asistencia.getInstance();
                Cont.setContador(1);
   ```
 * Intanciamos un objeto de tipo  Profesor
 * Instanciamos un  objeto de tipo Asistencia y le pasamos "1", a su metodo setter
 * ** En este caso al intanciar un objeto de tipo Asistencia, sin importar el  nombre, estamos haciendo referencia al mismo objeto *contador* intanciado en la clase *Asistencia* el cual  modifica la misma variable *Asis*, con el metodo *SetContador()* **
 
 ```
 Persona A= FactoryAcademia.Obtener("Administrativo");
                Asistencia Cont= Asistencia.getInstance();
                Cont.setContador(1);
 ```
* Intanciamos un objeto de tipo  Profesor
* Instanciamos un  objeto de tipo Asistencia y le pasamos "1", a su metodo setter
* **Nuevamente al intanciar un objeto de tipo Asistencia, sin importar el  nombre, estamos haciendo referencia al mismo objeto *contador* intanciado en la clase *Asistencia* el cual  modifica la misma variable *Asis*, con el metodo *SetContador()***


Finalmente en cada actividad de la applicacion  se hace un llamado al metodo Getter de la clase Asistencia **GetContador()**
   ``` 
  cont.setText("cont : " + Cont.GetContador());

   ``` 
  Lo que nos dara como resultando el numero de instancia creadas de cada clase, esto es posible a que la clase asistencia, siempre retornaba el objeto **contador** el cual le permitia modificar por medio del metodo **SetContador()**, la variable **Asis** la cual funcionaba como acumuladora durante todo el proceso de ejecuacion de la App.
  
  
  Referencias 
  
  * https://es.wikipedia.org/wiki/Singleton
  * https://es.wikipedia.org/wiki/Factory_Method_(patr%C3%B3n_de_dise%C3%B1o)
