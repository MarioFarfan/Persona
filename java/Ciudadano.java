
public class Ciudadano extends Persona {

    private String ine;
    private String cartilla;

    
    /*public Ciudadano (String nombre, String apellido1, String apellido2, int edad, String sexo, String curp,  String ine){
        super(nombre, apellido1, apellido2, edad, sexo, curp);
        super.setApellido1(apellido1);
        super.setApellido2(apellido2);
        super.setSexo(sexo);
        super.setCurp(curp);
        this.ine = ine;
    }

    public Ciudadano (String nombre, String apellido1, String apellido2,int edad,  String sexo, String curp,  String ine, String cartilla){
        super(nombre, apellido1, apellido2, edad, sexo, curp);
        super.setName(nombre);
        super.setApellido1(apellido1);
        super.setApellido2(apellido2);
        super.setSexo(sexo);
        super.setCurp(curp);
        this.ine = ine;
        this.cartilla = cartilla;
    }*/

    public void setIne(String ine) throws Error {
        if(!ine.equals(" ")) this.ine = ine;
        else throw new Error("La INE no puede estar vacía.");
    }
    
    public String getIne(){
        return ine;
    }

    public void setCartilla(String cartilla) throws Error {
        if(!cartilla.equals(" ")) this.cartilla = cartilla;
        else throw new Error("La Cartilla no puede estar vacía.");
    }

    public String getCartilla(){
        return cartilla;
    }
}