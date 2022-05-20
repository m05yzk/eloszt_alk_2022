
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
      
    }

    public String getFajta() {
        return fajta;
    }

    public boolean isGazdanal() {
        return gazdanal;
    }

    public void setGazdanal(boolean gazdanal) {
        this.gazdanal = gazdanal;
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
        return "Kutya neve: " + nev + ", Fajtája: " + fajta + ", Egészsége: " + egeszseg;
    }
 

    @Override
    public int compareTo(Kutya o) {
        Collator col = Collator.getInstance();
        return col.compare(this.nev, o.nev);
    }
    
    
    
    
    
}
