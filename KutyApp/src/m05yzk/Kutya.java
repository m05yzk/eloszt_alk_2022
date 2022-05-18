
package m05yzk;


public class Kutya {
    
    private String nev;
    private String fajta;
    private String egeszseg;

    public Kutya(String nev, String fajta) {
        this.nev = nev;
        this.fajta = fajta;
        this.egeszseg = "Egészséges";
    }
    public Kutya(String nev, String fajta, String egeszseg) {
        this.nev = nev;
        this.fajta = fajta;
        this.egeszseg = egeszseg;
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
        return "Kutya{" + "nev=" + nev + ", fajta=" + fajta + ", egeszseg=" + egeszseg + '}';
    }
    
    
    
    
}
