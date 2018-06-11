import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
public class Buscar{
	
	
	public DataOutputStream flujoSalida(String archivoSalida) throws Exception{
		DataOutputStream out= null;
		try {
		 	out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivoSalida)));
		} catch (Exception e){
			System.err.println(e);
			throw e;
		} finally{
			return out;
		}
	}
	
	public DataInputStream flujoEntrada(String archivoEntrada) throws Exception {
		DataInputStream in = null;
		try {
		 	in = new DataInputStream(new BufferedInputStream(new FileInputStream(archivoEntrada)));
		} catch (Exception e){
			System.err.println(e);
			throw e;
		} finally{
			return in;
		}
	} 
	
	public boolean guardarProducto(DataOutputStream out, Ciudadano ciudadano) throws Exception{
		boolean res = false;
		if (out != null && ciudadano != null){
			try{
				out.writeUTF(ciudadano.getName());
				out.writeUTF(ciudadano.getApellido1());
				out.writeUTF(ciudadano.getApellido2());
				out.writeInt(ciudadano.getEdad());
				out.writeUTF(ciudadano.getCurp());
				out.writeUTF(ciudadano.getSexo());
				out.writeUTF(ciudadano.getIne());	
				out.writeUTF(ciudadano.getCartilla());
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
	
	public Ciudadano leerProducto(DataInputStream in,String crp) throws Exception{
		Ciudadano p = null;
		String nombre;
    	String apellido1;
    	String apellido2;
		int edad;
		String curp;
		String sexo;
		String ine;
		String cartilla;
		
		try {
		    while (true) {
				nombre = in.readUTF();
				apellido1 = in.readUTF();
				apellido2 = in.readUTF();
				edad = in.readInt();
				curp = in.readUTF();
				sexo = in.readUTF();
				ine = in.readUTF();
				cartilla = in.readUTF();
				if (curp.equals(crp)){
					if (cartilla!=null){
		        		p = new Ciudadano(nombre, apellido1, apellido2, edad, curp, sexo, ine);
					} else {
						p = new Ciudadano(nombre, apellido1, apellido2, edad, curp, sexo, ine, cartilla);
					}
				}
				break;
		    }
		} catch (Exception e) {
			System.err.println(e + "Error 1");
			throw e;
		} finally {
			return p;
		}
		
	}
	
	public static void main (String[] args) throws IOException{
		Scanner read = new Scanner(System.in);
		System.out.println("BUSCAR CIUDADANO");
		System.out.println("Ingrese la INE: ");
		String ine = read.next().toUpperCase();
		FileInputStream file = new FileInputStream("Texto");
    	    try{
    	        while(true){
    	            ObjectInputStream ois = new ObjectInputStream(file);
    	            Ciudadano c;
    	            try {
    	                c = (Ciudadano)ois.readObject();
    	            }catch(EOFException eof){
    	                System.out.println(eof);
    	                break;
					}
					if (c.getIne().equals(ine)){
						System.out.println(c + "Encontrado");
					}

    	            System.out.println("********************************");
    	        }
    	    }catch(ClassNotFoundException e){
    	        System.out.println(e);
    	    } catch (IOException io){
    	        System.out.println(io);
			} finally{ file.close();}	
	}
}