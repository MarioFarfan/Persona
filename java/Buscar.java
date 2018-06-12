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

	public void imprimir(){
		try{
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Texto"));
            
            // Se lee el primer objeto
            Object c = ois.readObject();
            
            // Mientras haya objetos
            while (c!=null)
            {
                if (c instanceof Ciudadano)
                    System.out.println(c);
                c = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException e1){
            System.out.println ("Fin de fichero");
        }
        catch (Exception e2){
            e2.printStackTrace();
		}
	}
	public static void main (String[] args) throws IOException{

		Buscar b = new Buscar();
		b.imprimir();
		Scanner read = new Scanner(System.in);
		System.out.println("BUSCAR CIUDADANO");
		System.out.println("Ingrese la INE: ");
		String ine = read.next().toUpperCase();
		try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Texto"));
            Ciudadano c = (Ciudadano)ois.readObject();
            while (c!=null)
            {
                if (c instanceof Ciudadano && c.getIne().equals(ine))
                    System.out.println(c);
                c = (Ciudadano)ois.readObject();
            }
            ois.close();
        }
        catch (EOFException e1){
            System.out.println ("Resultado");
        }
        catch (Exception e2){
            e2.printStackTrace();
        }
	}
}