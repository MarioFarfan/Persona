import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;
public class Buscar{
	
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
		Ciudadano clectura,c = null;
		try {
		    while (true) {
				clectura = (Ciudadano) in.readObject();			
				if (clectura.getCurp().equals(curp)){
		        	c = clectura;
				}
		        
		    }
		} catch (Exception e) {
			System.err.println(e + "Error 2");
			throw e;
		} finally {
			return c;
		}
		
	}
	
	public static void main (String[] args){
		Buscar  b = new Buscar();
        Scanner read = new Scanner(System.in);
        System.out.println ("BUSCAR CIUDADANO");
		ObjectInputStream dataIn = null;
		Ciudadano cEncontrado = null;
		String miArchivo = "Texto";
        
		try {
			System.out.println("Ingrese la curp del ciudadano que desea buscar: ");
			String curp = read.next().toString();
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