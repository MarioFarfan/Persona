/*
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Prueba {

    public ObjectOutputStream flujoSalida(String archivoSalida) throws Exception{
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
	
	public ObjectInputStream flujoEntrada(String archivoEntrada) throws Exception {
		ObjectInputStream in = null;
		try {
		 	in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivoEntrada)));
		} catch (Exception e){
			System.err.println(e);
			throw e;
		} finally{
			return in;
		}
	} 
	
	public boolean guardarCiudadano(ObjectOutputStream out, Ciudadano ciudadano) throws Exception{
		boolean res = false;
		if (out != null && ciudadano != null){
			try{
				out.writeObject(ciudadano);
				res = true;
			} catch (Exception e){
				System.err.println(e);
				throw e;
			} finally {
				return res;
			}
		}
		else {
			return res;
		}
		
	}
	
	public Ciudadano leerPersona(ObjectInputStream in,String name) throws Exception{
		Ciudadano plectura,p = null;
	
		
		try {
		    while (true) {
				plectura = (Ciudadano) in.readObject();			
				if (plectura.getName() == name){
		        	p = plectura;
				}
		        
		    }
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		} finally {
			return p;
		}
		
	}

    public static void main (String [] args){
        ArrayList <Ciudadano> arr = new ArrayList();
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
                read.nextLine();
                if (persona.getEdad() >= 18 ){
                    System.out.println("Ingrese su INE: ");
                    String ine = read.next().toUpperCase();
                    if (persona.getSexo().equals("masculino")){
                        System.out.println("Ingresa tu cartilla militar: ");
                        String cartilla = read.next().toUpperCase();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        
                    } else {

                    System.out.println("¿Tienes cartilla Militar?");
                    System.out.println("1.- Si \n2.-No");
                    int i = read.nextInt();
                    if(i == 1){
                        read.next();
                        System.out.println("Ingrese su Cartilla: ");
                        String cartilla = read.nextLine().toUpperCase();
                        Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                        
                        }
                    }
                }
            }
            catch (InputMismatchException ime){
                System.out.println(ime + "\n La edad no debe contener caracteres");
                System.out.println("Ingrese la edad: ");
                read.next();
                persona.setEdad(read.nextInt());
                System.out.println("Ingrese el sexo: ");
                read.next();
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
                    
                        System.out.println("¿Tienes cartilla Militar?");
                        System.out.println("1.- Si /n 2.-No");
                        int i = read.nextInt();
                        if(i == 1){
                            System.out.println("Ingrese su Cartilla: ");
                            String cartilla = read.nextLine().toUpperCase();
                            Ciudadano ciudadano = new Ciudadano(persona, ine, cartilla);
                            
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
            System.out.println(persona.toString());
            //System.out.println(ciudadano.toString());
            System.out.println("_____________________________________");
            System.out.println("_____________________________________");
      }

        Prueba pa = new Prueba();
		String miArchivo = "Personas";
		ObjectOutputStream data = null;
		try {
			data = pa.flujoSalida(miArchivo);
			for(int x = 0 ; x < arr.size(); x++){
				pa.guardarCiudadano (data,arr.get(x));
			}
		} catch (IOException e) {
			System.err.println(e);
		} catch (Exception e){
			System.err.println(e);
		} finally {
			if ( data != null){
				try{
					data.close();
				} catch(Exception e){}
			}
		}
		System.out.println ("Buscar Ciudadano");
		ObjectInputStream dataIn = null;
		Ciudadano pEncontrado = null;
		try {
			dataIn = pa.flujoEntrada(miArchivo);
			pEncontrado = pa.leerPersona(dataIn, persona.getName());
		} catch (Exception e){
			System.err.println(e);	
		} finally {
			if ( dataIn != null) {
				try {
					dataIn.close();
				}catch(Exception e){}
				
			}
		}
		if ( pEncontrado != null){
			System.out.println(pEncontrado.toString());
		}

    }
}
*/