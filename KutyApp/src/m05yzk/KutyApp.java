
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
    
    public static void main(String[] args) {
        kutyaFeltoltes();
        //System.out.println("Teljes kutyalista:");
        //kutyaKiIras(kutyak);
        gazdaFeltoltes();
        //System.out.println("Gazdalista:");
        //gazdaKiIras(gazdik);
        //System.out.println("Gazda kutyái:");
        kutyatGazdahoz();
        
        
    }
    //Kutyanevek és fajták betöltése:
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
    
    private static void kutyatGazdahoz(){
        for (Gazda g : gazdik){
            
            Kutya kuty = randomKutya(kutyak);
            g.kutyatGazdahoz(kuty);
            kutyak.remove(kuty);
            System.out.println(g.toString()+"gazdához hozzárendelve: "+kuty.toString());
            
        }
        
    }
    
    //fájl beolvasása soronként:
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
        System.out.println("List tartalma:");
        for (String s : be){
            System.out.println(s);
        }
    }
    static void kutyaKiIras (List<Kutya> be){
        System.out.println("List tartalma:");
        for (Kutya s : be){
            System.out.println(s);
        }
    }
    
    static void gazdaKiIras (List<Gazda> be){
        System.out.println("List tartalma:");
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
}
