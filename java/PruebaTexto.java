import java.util.Scanner;
import java.io.*;
import java.util.*;

public class PruebaTexto {


    public static void main (String [] args) throws IOException{
        Scanner read = new Scanner(System.in);
        Persona persona = new Persona();
        BufferedWriter out = null;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Texto", true));

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
                read.nextLine();
                persona.setSexo(read.next());
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.next().toUpperCase();
                    if (persona.getSexo().equals("masculino")){
                        System.out.println("Ingresa tu cartilla militar: ");
                        String cartilla = read.next().toUpperCase();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        persona.toString();
                        System.out.println(ciudadano.toString());
                            oos.writeObject(ciudadano);
                            oos.close();
                        
                        
                    } else {

                    System.out.println("¿Tienes cartilla Militar?");
                    System.out.println("1.- Si \n2.-No");
                    int i = read.nextInt();
                    if(i == 1){
                        read.next();
                        System.out.println("Ingrese su Cartilla: ");
                        String cartilla = read.nextLine().toUpperCase();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        oos.writeObject(ciudadano);
                        oos.close();
                        }
                        else {
                            Ciudadano ciudadano = new Ciudadano(persona, ine);
                            oos.writeObject(ciudadano);
                            oos.close(); 
                            
                        }
                    }
                }else {System.out.println(persona.toString());}
            }
            catch (InputMismatchException ime){
                System.out.println(ime + "\n La edad no debe contener caracteres");
                System.out.println("Ingrese la edad: ");
                read.next();
                persona.setEdad(read.nextInt());
                System.out.println("Ingrese el sexo: ");
                //read.next();
                persona.setSexo(read.nextLine());
                
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.next().toUpperCase();
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si \n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                            System.out.println("Ingrese su Cartilla: ");
                            String cartilla = read.nextLine().toUpperCase();
                            Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                            oos.writeObject(ciudadano);
                            oos.close();
                        }
                        
                        else {
                            Ciudadano ciudadano = new Ciudadano(persona, ine);
                            oos.writeObject(ciudadano);
                            oos.close();
                        }
                    }
                }
            catch(NullPointerException npe){
                System.out.println(npe);
                System.out.println("El sexo solo puede ser masculino o feminino");
                System.out.println("Ingrese el sexo nuevamente");
                read.next();
                persona.setSexo(read.next());
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.next().toUpperCase();
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si \n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                            System.out.println("Ingrese su Cartilla: ");
                            String cartilla = read.nextLine().toUpperCase();
                            Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                            try {   
                                oos.writeObject(ciudadano);
                                oos.close();
                            } catch (IOException e) {   
                                System.out.println(e);   
                            } 
                        }
                        
                        else {
                            Ciudadano ciudadano = new Ciudadano(persona, ine);
                            oos.writeObject(ciudadano);
                            oos.close();
                            }
                        }
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
                    
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si /n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                            System.out.println("Ingrese su Cartilla: ");
                            String cartilla = read.nextLine().toUpperCase();
                            Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                            oos.writeObject(ciudadano);
                            oos.close();
                        }
                        
                        else {
                            Ciudadano ciudadano = new Ciudadano(persona, ine);
                            oos.writeObject(ciudadano);
                            oos.close();
                        }
                    }
                }
            //res = true;
        //}

    }
}
