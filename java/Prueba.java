import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Prueba {
    public static void main (String [] args){
        Scanner read = new Scanner(System.in);
        Persona persona = new Persona();

        boolean res=false;
        //while (res==false){
            try {
                System.out.println("Ingrese el nombre: ");
                persona.setName(read.nextLine());
                System.out.println("Ingrese el primer apellido: ");
                persona.setApellido1(read.nextLine());
                System.out.println("Ingrese el segundo apellido: ");
                persona.setApellido2(read.nextLine());
                System.out.println("Ingrese la curp: ");
                persona.setCurp(read.nextLine().toUpperCase());
                System.out.println("Ingrese la edad: ");
                persona.setEdad(read.nextInt());
                System.out.println("Ingrese el sexo: ");
                persona.setSexo(read.next());
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.nextLine().toUpperCase();
                    if (persona.getSexo().equals("masculino")){
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si \n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                        System.out.println("Ingrese su Cartilla: ");
                        String cartilla = read.nextLine().toUpperCase();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        }
                    }
                    else {
                        Ciudadano ciudadano = new Ciudadano(persona, ine);
                    }
                }
            }
            catch (InputMismatchException ime){
                System.out.println(ime + "\n La edad no debe contener caracteres");
                System.out.println("Ingrese la edad: ");
                read.next();
                persona.setEdad(read.nextInt());
                System.out.println("Ingrese el sexo: ");
                persona.setSexo(read.next());
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.nextLine().toUpperCase();
                    if (persona.getSexo().equals("masculino")){
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si \n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                        System.out.println("Ingrese su Cartilla: ");
                        String cartilla = read.nextLine().toUpperCase();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        }
                    }
                    else {
                        Ciudadano ciudadano = new Ciudadano(persona, ine);
                    }
                }
                
            }
            catch(NullPointerException npe){
                System.out.println(npe);

                System.out.println("El sexo solo puede ser masculino o feminino");
                System.out.println("Ingrese el sexo nuevamente");
                read.next();
                persona.setSexo(read.next());
            }
            catch(Error e){
                System.out.println(e);
                System.out.println("Ingrese el nombre: ");
                persona.setName(read.nextLine());
                System.out.println("Ingrese el primer apellido: ");
                persona.setApellido1(read.nextLine());
                System.out.println("Ingrese el segundo apellido: ");
                persona.setApellido2(read.nextLine());
                System.out.println("Ingrese la curp: ");
                persona.setCurp(read.next());
                System.out.println("Ingrese la edad: ");
                persona.setEdad(read.nextInt());
                System.out.println("Ingrese el sexo: ");
                persona.setSexo(read.next());
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.nextLine();
                    if (persona.getSexo().equals("masculino")){
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si /n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                        System.out.println("Ingrese su Cartilla: ");
                        String cartilla = read.nextLine();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        }
                    }
                    else {
                        Ciudadano ciudadano = new Ciudadano(persona, ine);
                    }
                }
            }
            //res = true;
        //}
        finally{
        System.out.println("_____________________________________");
        System.out.println("_____________________________________");
        System.out.println("Nombre: " + persona.getName() + " "+persona.getApellido1() + " "+persona.getApellido2());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Sexo: " +  persona.getSexo());
        System.out.println("Curp: " + persona.getCurp());
        
        if(persona.getEdad() >= 18) {
            System.out.println("INE: " + ciudadano.getIne());
            if(persona.getSexo().equals("masculino")){
                System.out.println("Cartilla: " + ciudadano.getCartilla());
            }
        }
        System.out.println("_____________________________________");
        System.out.println("_____________________________________");
      }
    }
}
