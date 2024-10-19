public class Manager extends Angajat {

    private String parola = "manager123";
    private String nume;


    public Manager(String nume, String functie){
        super(functie);
        this.nume = nume;
        setAutoritate("Medium");
    }
}
