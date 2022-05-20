
package m05yzk;
import java.util.ArrayList;
import java.util.Random;

public class Klinika {
    
    private String klinikaNev;
    private int kapacitas;
    private ArrayList<Kutya> felvettKutyak;

    public Klinika(String klinikaNev) {
        this.klinikaNev = klinikaNev;
        this.kapacitas = new Random().nextInt(2, 5);
        this.felvettKutyak = new ArrayList<>();
    }

    
    public String getKlinikaNev() {
        return klinikaNev;
    }

    
    public int getKapacitas() {
        return kapacitas;
    }

    public void setKapacitas(int kapacitas) {
        this.kapacitas = kapacitas;
    }

    public void KutyaFelvetel(Kutya kutya){
        
        
        felvettKutyak.add(kutya);
        
    }
    public void KutyaGyogyitas (){
        
    }
    
    
    public ArrayList<Kutya> getFelvettKutyak() {
        return felvettKutyak;
    }

    
    
    
    
    
}
