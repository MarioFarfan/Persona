import java.util.Scanner;

public class Prueba {
    public static void main (String [] args){
        Scanner read = new Scanner(System.in);
        Persona persona = new Persona();
        Ciudadano ciudadano = new Ciudadano();

        while (true){

            
                System.out.println("Ingrese el nombre: ");
                persona.setName(read.nextLine());
                System.out.println("Ingrese el primer apellido: ");
                persona.setApellido1(read.next());
                System.out.println("Ingrese el segundo apellido: ");
                persona.setApellido2(read.next());
                System.out.println("Ingrese la curp: ");
                persona.setCurp(read.next());
                System.out.println("Ingrese la edad: ");
                persona.setEdad(read.nextInt());
                System.out.println("Ingrese el sexo: ");
                persona.setSexo(read.next());

                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    ciudadano.setIne(read.next());
                    if (persona.getSexo().equals("masculino")){
                        System.out.println("Ingrese su Cartilla: ");
                        ciudadano.setCartilla(read.next());
                    }
                }
            break;
        }
            
        
        System.out.println("_____________________________________");
        System.out.println("_____________________________________");
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
        System.out.println("_____________________________________");
        System.out.println("_____________________________________");

        
    }
}

//Referencia para manejar archivos de texto y binarios en JAVA para mañana