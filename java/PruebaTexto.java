import java.util.Scanner;
import java.io.*;
import java.util.*;
//Clase en la que se solicitan los datos al usuario para despues buscarlo
public class PruebaTexto {

    public ObjectOutputStream flujoSalida(String archivoSalida) throws Exception {
		ObjectOutputStream out= null;
		try {
		 	out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(archivoSalida)));
		} catch (Exception e){
			System.err.println(e);
			throw e;
		} finally{
			return out;
		}
	}
// metodo que recibe un String que recibe el nombre del arvhico.	
	public ObjectInputStream flujoEntrada(String archivoEntrada) throws Exception {
		ObjectInputStream in = null;
		try {
		 	in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivoEntrada)));
		} catch (Exception e){
			System.err.println(e + "error 1");
			throw e;
		} finally {
			return in;
		}
	} 
	
	
	public Ciudadano leerCiudadano(ObjectInputStream in,String curp) throws Exception{
        Ciudadano clectura = null;
        Ciudadano c = null;
        if (in != null){
            try {
                while (true) {
                    clectura = (Ciudadano) in.readObject();			
                    if (clectura.getCurp().equals(curp)){
                        c = clectura;
                    }
                    
                }
            } catch (Exception e) {
                System.err.println(e + "    ERROR 2");
                throw e;
            } finally {
                return c;
            }
        }
        return c;
	}

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
        while(true){
//
        System.out.println ("BUSCAR CIUDADANO");
		ObjectInputStream dataIn = null;
		Ciudadano cEncontrado = null;
		String miArchivo = "Texto";
        PruebaTexto b = new PruebaTexto();
		try {
			System.out.println("Ingrese la curp del ciudadano que desea buscar: ");
			String curp = read.next();
			dataIn = b.flujoEntrada(miArchivo);
			cEncontrado = b.leerCiudadano(dataIn, curp);
		} catch (Exception e){
			System.err.println(e);	
		} finally {
			if ( dataIn != null) {
				try {
					dataIn.close();
				}catch(Exception e){
					System.out.print(e + "Error 3");
				}
				
			}
		}
		if ( cEncontrado != null){
			System.out.println(cEncontrado.toString());
        }
    }

    }
}
