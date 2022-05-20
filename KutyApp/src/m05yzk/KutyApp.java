
package m05yzk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


public class KutyApp {

    private static List<String> stringLista;
    private static ArrayList<String> kutyanevek;
    private static ArrayList<String> kutyafajtak;
        
    private static ArrayList<Kutya> kutyak;
    private static ArrayList<Gazda> gazdik;
    private static ArrayList<Klinika> klinikak;
    
    public static void main(String[] args) {
        kutyaFeltoltes();
        //System.out.println("Teljes kutyalista:");
        //kutyaKiIras(kutyak);
        gazdaFeltoltes();
        //System.out.println("Gazdalista:");
        //gazdaKiIras(gazdik);
        kutyakSzetOsztasa();
        klinikaFelToltes();
        
        kutyatKlinikaba();
        
        
        //ezt lehetne gombra rakni
        System.out.println("Gazdák kutyái kutyanév szerint rendezve:");
        gazdaKutyaiKiIras();
        
        System.out.println("Klinikák kutyái kutyanév szerint rendezve:");
        klinikaKutyaiKiIras();
        
        
        
        
        
    }
    //Kutyanevek és fajták beolvasása és feltöltése:
    private static void kutyaFeltoltes() {
        
        kutyanevek = new ArrayList<>();
        kutyafajtak = new ArrayList<>();
        List<String> kutyaNevBe = fajlBeolvasas("src/source/kutyanevek.txt");
        for (String s : kutyaNevBe){
            kutyanevek.add(s);
            
        }
        List<String> kutyaFajtaBe = fajlBeolvasas("src/source/kutyafajtak.txt");        
        for (String s : kutyaFajtaBe){
            kutyafajtak.add(s);
        }
        
        kutyak = new ArrayList<>();
        for (String s : kutyanevek){
            kutyak.add(new Kutya(s,randomSor(kutyafajtak)));
        }
    }
    
    //Gazdák neveinek beolvasása és feltöltése
    private static void gazdaFeltoltes(){
        gazdik = new ArrayList<>();
        List<String> gazdaBe = fajlBeolvasas("src/source/gazdanevek.txt");        
        for (String s : gazdaBe){
            gazdik.add(new Gazda(s));
        }
    }
    
    //Gazdákhoz kutyák rendelése és kutyák listáról levétele
    private static void kutyakSzetOsztasa(){
        
        
        for (Gazda g : gazdik){
            
            for (int i = new Random().nextInt(1, 4); i > 0; i--) {
                Kutya kuty = randomKutya(kutyak);
                g.kutyatGazdahoz(kuty);
                kutyak.remove(kuty);
                System.out.println(g.getNev()+" gazdához hozzárendelve: "+kuty.getNev()+", "+kuty.getFajta());
            
            }
        }
    }
    
    
    //Kutyákat klinikába random móon, avagy megbetegítések:
    private static void kutyatKlinikaba(){
        
        for (Klinika c : klinikak) {
            while (c.getFelvettKutyak().size() + 1 < c.getKapacitas()) {
                Kutya rkuty = randomKutya(kutyak);
              
                if (rkuty.isGazdanal() == true) {
                    
                    c.KutyaFelvetel(rkuty);
                    
                }
                
        
                
            }
            
        }
        
        
        
        
        
        
        
    }
    
    //fájl beolvasása soronként órai példa alapján
    private static List<String> fajlBeolvasas(String fajlNev){
        
        try {
            stringLista = Files.readAllLines(Paths.get(fajlNev));
        } catch (IOException ex) {
            Logger.getLogger(KutyApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringLista;
    }
    
    static void kiIrTeszt(){
        /*System.out.println("Nevek:");
        for (String s : kutyanevek){
            System.out.println(s);
        }*/
        /* összes kutya adata kiírva:
        System.out.println("Kutyatömb:");
        for (Kutya s : kutyak){
            System.out.println(s);
        }*/
        
        
        System.out.println("VÉGE");
    }
    
    static void listKiIras (List<String> be){
        for (String s : be){
            System.out.println(s);
        }
    }
    static void kutyaKiIras (List<Kutya> be){
         for (Kutya s : be){
            System.out.println(s);
        }
    }
    static void gazdaKiIras (List<Gazda> be){
        for (Gazda s : be){
            System.out.println(s);
        }
    }
        
    //random sor ArrayListből:
    public static String randomSor(ArrayList<String> i) { 
        return i.get(new Random().nextInt(i.size()));

    }
    public static Kutya randomKutya(ArrayList<Kutya> i) { 
        return i.get(new Random().nextInt(i.size()));

    }
    
    //Gazdák kutyái kutyanév szerint rendezve
    private static void gazdaKutyaiKiIras(){
        
        for (Gazda g : gazdik){
            System.out.println("Gazda: "+g.getNev());
            kutyaKiIras(g.kutyakNevSzerint());
        }
    }
    
    //Klinikák nevének beolvasása és létrehozásuk
    private static void klinikaFelToltes(){
        klinikak = new ArrayList<>();
        List<String> klinikaBe = fajlBeolvasas("src/source/klinikanevek.txt");        
        for (String k : klinikaBe){
            klinikak.add(new Klinika(k));
        }
    }
    
    private static void klinikaKutyaiKiIras(){
        
        for (Klinika k : klinikak){
            System.out.println("Klinika: "+k.getKlinikaNev());
            kutyaKiIras(k.kutyakNevSzerint());
        }
    }
}

