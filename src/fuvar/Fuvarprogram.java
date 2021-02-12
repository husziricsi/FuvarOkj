package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fuvarprogram {

    public static void main(String[] args) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get("fuvar.csv"));
        ArrayList<Fuvar> fuvarok = new ArrayList();

        for (int i = 1; i < sorok.size(); i++) {
            fuvarok.add(new Fuvar(sorok.get(i)));
        }

        int fuvarokszama = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            fuvarokszama++;
        }
        System.out.print("3.feladat: " + fuvarokszama + " fuvar");
        double osszesbev = 0;
        int osszfuvar = 0;
        System.out.println("4. feladat");
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getAzonosito() == 6185) {
                osszfuvar++;
                osszesbev += fuvarok.get(i).getViteldij();
            }

        }
        System.out.println(osszfuvar + "fuvar alatt: " + osszesbev + "$");
        System.out.println("5. feladat");

        HashMap<String, Integer> fizetesmodok = new HashMap<>();
        for (int i = 0; i < fuvarok.size(); i++) {
            String kulcs = fuvarok.get(i).getFizetesmod();
            if (!fizetesmodok.containsKey(kulcs)) {
                fizetesmodok.put(kulcs, 1);
            } else {
                int ertek = fizetesmodok.get(kulcs);
                fizetesmodok.put(kulcs, ++ertek);
            }
        }

        for (Map.Entry<String, Integer> entry : fizetesmodok.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + ": " + value + " fuvar");
        }

        System.out.println("6. feladat");
        double ossztav = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            ossztav += fuvarok.get(i).getTavolsag();
        }
        System.out.printf("%.2f km ",(ossztav*1.6));
        
        System.out.println("7.feladat");
        int max = 0;
        int ez = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
           if(fuvarok.get(i).getIdotartam()> max) {
            max = fuvarok.get(i).getIdotartam();
            ez = i;
           }
        }
        System.out.println(fuvarok.get(ez).getIdotartam()+" másodperc");
        System.out.println("Taxi azonositoja: "+fuvarok.get(ez).getAzonosito());
        System.out.println(fuvarok.get(ez).getTavolsag()+ " km");
        System.out.println(fuvarok.get(ez).getViteldij()+ " $");
    } 
    

}
