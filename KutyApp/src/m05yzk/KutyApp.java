
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
        kiIrTeszt();
        
        
    }
    private static void kutyaFeltoltes() {
        
        kutyanevek= new ArrayList<>();
        kutyafajtak= new ArrayList<>();
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
        Kutya elsoKutya = new Kutya(randomSor(kutyanevek),randomSor(kutyafajtak));
        //Kutya masikKutya = new Kutya(masikKutya.get)
        
        //String ehh = new String();
        
         
    
    }
    
    
    private static List<String> fajlBeolvasas(String fajlNev){
        
        try {
            stringLista = Files.readAllLines(Paths.get(fajlNev));
        } catch (IOException ex) {
            Logger.getLogger(KutyApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringLista;
    }
    
    static void kiIrTeszt(){
        System.out.println("Nevek:");
        for (String s : kutyanevek){
            System.out.println(s);
        }
        System.out.println("Fajták");
        for (String s : kutyafajtak){
            System.out.println(s);
        }
        System.out.println(randomSor(kutyafajtak));
        System.out.println("VÉGE");
    }
    
    
    public static String randomSor(ArrayList<String> i) {
        return i.get(new Random().nextInt(i.size()));

    }
}
