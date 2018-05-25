
public class Ciudadano extends Persona {

    private String ine;
    private String cartilla;


    public Ciudadano (Persona persona, String ine)throws Error {
        
        this.ine = ine;
    }

    public Ciudadano (Persona persona,  String ine, String cartilla)throws Error {
        this.ine = ine;
        if(!cartilla.equals(" ")) this.cartilla = cartilla;
        else throw new Error("No se puede crear un ciudadano sin cartilla");
    }

    public void setIne(String ine) throws Error {
        if(!ine.equals(" ")) this.ine = ine;
        else throw new Error("La INE no puede estar vacía.");
    }

    public String getIne(){
        return ine;
    }

    public void setCartilla(String cartilla) throws Error {
        if(!cartilla.equals(" ")) this.cartilla = cartilla;
        else throw new Error("No se puede crear un ciudadano sin cartilla");
    }

    public String getCartilla(){
        return cartilla;
    }
}
