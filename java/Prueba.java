import java.util.Scanner;

public class Prueba {
    public static void main (String [] args){
        Scanner read = new Scanner(System.in);
        Persona persona;

        while (true){

            
                System.out.println("Ingrese el nombre: ");
                String nombre = read.next();
                System.out.println("Ingrese el primer apellido: ");
                String apellido1 = read.next();
                System.out.println("Ingrese el segundo apellido: ");
                String apellido2 = read.next();
                System.out.println("Ingrese la curp: ");
                String curp = read.next();
                System.out.println("Ingrese la edad: ");
                int edad = read.nextInt();
                System.out.println("Ingrese el sexo: ");
                String sexo = read.next();
                //persona = new Persona(nombre,apellido1,apellido2,curp,edad,sxo);

                if (edad >= 18 && sexo.equals("masculino")){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.next();
                    System.out.println("Ingrese su Csrtilla: ");
                    String cartilla = read.next();
                    persona = new Ciudadano (nombre, apellido1, apellido2, sexo, curp, ine, cartilla);
                } else if (edad >= 18 && sexo.equals("femenino")){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.next();
                     persona = new Ciudadano (nombre, apellido1, apellido2, sexo, curp, ine);
                } else {
                    persona = new Persona (nombre, apellido1, apellido2, sexo, curp);
                }                             
            
            break;
        }
            
        System.out.println(persona.getName() + " "+persona.getApellido1() + " "+persona.getApellido2());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Sexo -.- " +  persona.getSexo());
        System.out.println("Curp: " + persona.getCurp());
        
        if(persona.getEdad() >= 18) {
            System.out.println("INE: " + persona.getIne());
            if(persona.getSexo().equals("masculino")){
                System.out.println("Cartilla: " + persona.getCartilla());
            }
        }

        
    }
}

//Referencia para manejar archivos de texto y binarios en JAVA para mañana