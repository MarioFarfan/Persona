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
			System.err.println(e);
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
				if (clectura.getCurp() == curp){
		        	c = clectura;
				}
		        
		    }
		} catch (Exception e) {
			System.err.println(e);
			throw e;
		} finally {
			return c;
		}
		
	}
	
	public static void main (String[] args){
		
        Scanner read = new Scanner(System.in);
        System.out.println ("BUSCAR CIUDADANO");
		ObjectInputStream data = null;
        Ciudadano cEncontrado = null;
        Buscar  cu = new Buscar();
		try {
            System.out.println("Ingrese la curp del ciudadano que desea buscar: ");
			data = cu.flujoEntrada("Archivo.txt");
			cEncontrado = cu.leerCiudadano(data, read.next());
		} catch (Exception e){
			System.err.println(e);	
		} finally {
			if ( data != null) {
				try {
					data.close();
				}catch(Exception e){}
				
			}
		}
		if ( cEncontrado != null){
			System.out.println(cEncontrado.toString());
		}
			
	}
}