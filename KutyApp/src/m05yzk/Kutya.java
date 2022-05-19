
package m05yzk;

import java.text.Collator;


public class Kutya implements Comparable<Kutya>{

    
    
    private String nev;
    private String fajta;
    private String egeszseg;
    private boolean gazdanal;
    private String gazdaNeve;

    public Kutya(String nev, String fajta) {
        this.nev = nev;
        this.fajta = fajta;
        this.egeszseg = "Egészséges";
        this.gazdanal = true;
        this.gazdaNeve = "";
      
    }

    public Kutya(String nev, String fajta, String egeszseg, boolean gazdanal, String gazdaNeve) {
        this.nev = nev;
        this.fajta = fajta;
        this.egeszseg = egeszseg;
        this.gazdanal = gazdanal;
        this.gazdaNeve = gazdaNeve;
    }

    
    

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEgeszseg() {
        return egeszseg;
    }

    public void setEgeszseg(String egeszseg) {
        this.egeszseg = egeszseg;
    }

     
    
    @Override
    public String toString() {
        return "Név: " + nev + ", Fajta: " + fajta + ", Egészség: " + egeszseg;
    }
 

    @Override
    public int compareTo(Kutya o) {
        Collator col = Collator.getInstance();
        return col.compare(this.nev, o.nev);
    }
    
    
    
    
    
}
