
package m05yzk;


public class Kutya {
    
    private String nev;
    private String fajta;
    private String egeszseg;
    private boolean gazdanal;

    public Kutya(String nev, String fajta) {
        this.nev = nev;
        this.fajta = fajta;
        this.egeszseg = "Egészséges";
        this.gazdanal = true;
    }

    public Kutya(String nev, String fajta, String egeszseg, boolean gazdanal) {
        this.nev = nev;
        this.fajta = fajta;
        this.egeszseg = egeszseg;
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
        return "Név: " + nev + ", Fajta: " + fajta + ", Egészség: " + egeszseg;
    }
    
    
    
    
}
