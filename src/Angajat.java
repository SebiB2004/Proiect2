import java.util.ArrayList;
import java.util.List;

public class Angajat {

    String functie;
   String autoritate;
   static String[] listaAngajati = {"Ingrijitor", "Manager", "Secretar", "Patron"};
   private String nume;

    public Angajat(){

    }

    public Angajat(String nume, String functie){
        this.functie = functie;
        this.nume = nume;
    }

    public String getNume(){
        return this.nume;
    }

    public String getFunctie(){

        return this.functie;
    }

    public void setAutoritate(String autoritate){
        this.autoritate = autoritate;
    }

    public String getAutoritate(){
        return this.autoritate;
    }

    public static String[] getListaAngajati(){
      return listaAngajati;
    }
}
