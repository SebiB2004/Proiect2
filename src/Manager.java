public class Manager extends Angajat {

    private String parola = "manager123";
    private String nume;


    public Manager(String nume, String functie){
        super(nume, functie);
        this.nume = nume;
        setAutoritate("Medium");
    }
}
