
public class Ciudadano extends Persona {

    private String ine;
    private String cartilla;


    public Ciudadano (Persona persona, String ine)throws Error {

        this.ine = ine;
    }

    public Ciudadano (Persona persona,  String ine, String cartilla)throws Error {
        this.ine = ine;
        if(!cartilla.equals(" ")) this.cartilla = cartilla;
        else throw new Error("No eres ciudadano");
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

    public String toString() throws Error{
        if (super.getSexo().equals("masculino")&& cartilla.equals(null)){
        throw new Error("no se puede crear ciudadano");}
        else {
        return super.toString() + this.getClass().getSimpleName() + "\nINE: " + ine +"\nCartilla: " + cartilla;
    }
}
}
