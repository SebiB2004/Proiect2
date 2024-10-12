import java.util.*;

public class Ingrijitor extends Angajat{
   private String parola = "ingrijitor123";
   private String nume;

   public Ingrijitor(String nume, String functie){
       super(functie);
       this.nume = nume;
       setAutoritate("LOW");
   }

   public String getParola(){
       return this.parola;
   }
}


