import java.io.Serializable;
public class Ciudadano extends Persona implements Serializable{

    private String ine;
    private String cartilla;
    private Persona persona;

    public Ciudadano (Persona persona, String ine)throws Error {
        this.persona = persona;
        this.ine = ine;
    }

    public Ciudadano (Persona persona,  String ine, String cartilla)throws Error {
        this.persona = persona;
        this.ine = ine;
        if(!cartilla.equals(" ")) this.cartilla = cartilla;
        else throw new Error("No eres ciudadano");
    }
    public Ciudadano (String nombre, String apellido1, String apellido2, int edad, String curp, 
    String sexo, String ine, String cartilla) {
        super.setName(nombre);
        super.setApellido1(apellido1);
        super.setApellido2(apellido2);
        super.setEdad(edad);
        super.setCurp(curp);
        super.setSexo(sexo);
        this.ine = ine;
        this.cartilla = cartilla;
    }

    public Ciudadano (String nombre, String apellido1, String apellido2, int edad, String curp, 
    String sexo, String ine) {
        super.setName(nombre);
        super.setApellido1(apellido1);
        super.setApellido2(apellido2);
        super.setEdad(edad);
        super.setCurp(curp);
        super.setSexo(sexo);
        this.ine = ine;
    }

    public void setIne(String ine) throws Error {
        if(!ine.equals(" ")){
            for (int x=0; x < ine.length(); x++) {
                if (ine.charAt(x) != ' ')
                  this.ine += ine.charAt(x);
              }
            }
        else throw new Error("La INE no puede estar vacía.");
    }

    public String getIne(){
        return ine;
    }

    public void setCartilla(String cartilla) throws Error {
        if(!cartilla.equals(" ")){
            for (int x=0; x < cartilla.length(); x++) {
                if (cartilla.charAt(x) != ' ')
                  this.cartilla += cartilla.charAt(x);
              }
        }
        else throw new Error("No eres ciudadano");
    }

    public String getCartilla(){
        return cartilla;
    }

    public String getCurp(){
        return super.getCurp();
    }

    public String toString() {
        return this.getClass().getSimpleName() + "  " + persona.toString() + "\nINE: " + ine +"\nCartilla: " + cartilla + "\n" + "\n";
    }
}
