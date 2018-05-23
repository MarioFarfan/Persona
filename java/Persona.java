import java.text.Normalizer;


public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String curp;
    private String sexo;
    private String [] sexOptions = new String []{"masculino","femenino"};;

    
    public void setName(String nombre) throws Error {
        if(!nombre.equals("")) this.nombre = nombre;
        else throw new Error("El nombre no puede estar vacío.");
    }

    public void setApellido1(String apellido1) throws Error {
        if(!apellido1.equals("")) this.apellido1 = apellido1;
        else throw new Error("El apellido no puede estar vacío.");
    }

    public void setApellido2(String apellido2) throws Error {
        if(!apellido2.equals("")) this.apellido2 = apellido2;
        else throw new Error("El apellido no puede estar vacío.");
    }

    public void setCurp(String curp) throws Error {
        if(!curp.equals("")) this.curp = curp;
        else throw new Error("La curp no puede estar vacía.");
    }

    public void setSexo(String sexo) throws Error {
		boolean valid = false;
		if(!sexo.equals("")) {
			for(byte i=0; i<sexOptions.length; i++) {
				if(sexOptions[i].equals(sexo.toLowerCase())) {
					this.sexo = sexo;
					valid = true;
					break;
				}
			}
		}
		if(!valid) throw new Error("El sexo solo puede ser masculino o femenino.");
	}

    public void setEdad(int age) throws Error {
        if(age >= 0) this.edad = age;
        else throw new Error("La edad no puede ser negativa.");
    }

    public int getEdad(){
        return edad;
    }

    public String getSexo(){
        return sexo;
    }

    public String getName (){
        return nombre;
    }

    public String getApellido1(){
        return apellido1;
    }

    public String getApellido2(){
        return apellido2;
    }

    public String getCurp (){
        return curp;
    }

    public String getIne() {
        return null;
    }

    public String getCartilla() {
        return null;
    }
}