public class Produs {
    private String denumire;
    private int cantitate;
    private int pret;

    public Produs(String denumire, int cantitate, int pret){
        this.denumire = denumire;
        this.cantitate = cantitate;
        this.pret = pret;
    }
   public String getNume(){
        return this.denumire;
   }
   public int getCantitate(){
        return this.cantitate;
   }
   public int getPret(){
        return this.pret;
   }
}
