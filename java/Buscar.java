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