# software_aplication

En diseño de software, el patrón de diseño Factory Method consiste en utilizar una clase constructora (al estilo del Abstract Factory) abstracta con unos cuantos métodos definidos y otro(s) abstracto(s): el dedicado a la construcción de objetos de un subtipo de un tipo determinado. Es una simplificación del Abstract Factory, en la que la clase abstracta tiene métodos concretos que usan algunos de los abstractos; según usemos una u otra hija de esta clase abstracta, tendremos uno u otro comportamiento.


'''

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


''' 
