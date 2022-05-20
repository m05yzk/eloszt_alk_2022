
package m05yzk;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;


public class Gazda implements Comparable<Gazda>{
    private String nev;
    private ArrayList<Kutya> sajatKutyak;

    
    public Gazda(String nev) {
        this.nev = nev;
        this.sajatKutyak = new ArrayList<>();
    }

    public String getNev() {
        return nev;
    }

    public ArrayList<Kutya> getSajatKutyak() {
        return sajatKutyak;
    }
    
    public String GazdaKutyai(){
        return sajatKutyak.toString();
        
    }
    public void kutyatGazdahoz(Kutya kutya){
        sajatKutyak.add(kutya);
        
    }
    
    public ArrayList<Kutya> kutyakNevSzerint(){
       ArrayList<Kutya> sajatKutyakNevSzerint = sajatKutyak;
       Collections.sort(sajatKutyakNevSzerint);
       
       return sajatKutyakNevSzerint;
    }
    
    

    @Override
    public int compareTo(Gazda o) {
        
        Collator col = Collator.getInstance();
        return col.compare(this.nev, o.nev);
        
        
    }

    @Override
    public String toString() {
        return "Gazda neve: " + nev;
    }
    
    
    


    
    
    
}
