import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;
//clase para buscar a un ciudadano dependiendo de su curp
public class Buscar{
	public void flujoSalida(String archivoSalida) throws Exception {
		try {
		 	extracted(archivoSalida);
		} catch (Exception e){
			System.err.println(e);
			throw e;
		}
	}
	//metodo objectOutputStram
	private ObjectOutputStream extracted(String archivoSalida) throws IOException, FileNotFoundException {
		return new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(archivoSalida)));
	}

	public void flujoEntrada(String archivoEntrada) throws Exception {
		try {
		 	extracted2(archivoEntrada);
		} catch (Exception e){
			System.err.println(e);
			throw e;
		} 
	}
	private ObjectInputStream extracted2(String archivoEntrada) throws IOException, FileNotFoundException {
		return new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivoEntrada)));
	}

	// leer ciudadano comparar .getcurp con curp
	public Ciudadano leerCiudadano(ObjectInputStream in, String curp) throws Exception{
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
//metodo en el cual con el Scanner podemos interactuar para encontrar al ciudadano por medio de su curp
	public static void main (String[] args){
		
        Scanner read = new Scanner(System.in);
        System.out.println ("BUSCAR CIUDADANO");
		ObjectInputStream data = null;
        Ciudadano cEncontrado = null;
        Buscar  cu = new Buscar();
		try {
            System.out.println("Ingrese la curp del ciudadano que desea buscar: ");
			String archivoEntrada = "Archivo.txt";
			read.next();
			cEncontrado = cu.leerCiudadano(data, read.nextLine());
			System.out.println (" linea 66");
		} catch (Exception e){
			System.err.println(e);	
		} finally {
			if ( data != null) {
				try {
					cEncontrado.toString();
				}catch(Exception e){}
				
			}
		}
		if ( cEncontrado != null){
			System.out.println(cEncontrado.toString());
		}
			
	}
}

