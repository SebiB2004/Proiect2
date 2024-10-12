public class Angajat {

    String functie;
   String autoritate;

    public Angajat(){

    }

    public Angajat(String functie){
        this.functie = functie;
    }

    public void getFunctie(){
        System.out.println("Functia angajatului este " + this.functie);
    }

    public void setAutoritate(String autoritate){
        this.autoritate = autoritate;
    }

    public String getAutoritate(){
        return this.autoritate;
    }
}
