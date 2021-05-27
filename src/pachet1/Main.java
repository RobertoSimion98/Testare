package pachet1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int ok=0;
        try {
            File in =  new File("plagiat.in");
            FileWriter out = new FileWriter("plagiat.out");
            Scanner s = new Scanner(in);
            int nr_harti = s.nextInt();
            if(nr_harti<1 || nr_harti>5){
                System.out.println("Numarul de harti trebuie sa fie intre [1,5]");
                return;
            }
            for (int t = 0; t < nr_harti; t ++){
                int nr_stele = s.nextInt();
                if(nr_stele<1 || nr_stele>400){
                    System.out.println("Numarul de stele trebuie sa fie intre [1,400]");
                    return;
                }
                int[] x = new int[nr_stele];
                int[] y = new int[nr_stele];
                ok=0;
                HashMap<Pair, Integer> coordonate = new HashMap<>();
                for (int i = 0; i < nr_stele; i ++){
                    x[i]=s.nextInt();
                    y[i]=s.nextInt();
                    if(x[i]<0 || x[i]>109){
                        System.out.println("Coordonatele stelelor trebuie sa fie intre [0,109]");
                        return;
                    }
                    if(y[i]<0 || y[i]>109){
                        System.out.println("Coordonatele stelelor trebuie sa fie intre [0,109]");
                        return;
                    }
                    Pair p = new Pair (x[i],y[i]);
                    if (coordonate.containsKey(p)) {
                        coordonate.put(p, coordonate.get(p) + 1);
                    }
                    else {
                        coordonate.put(p, 1);
                    }
                    if(coordonate.get(p)>1){
                        System.out.println("Nu pot exista două stele cu aceleaşi coordonate");
                        return;
                    }
//                    for (Map.Entry<Pair, Integer> entry : coordonate.entrySet())
//                    {
//                        System.out.println(entry.getKey() + " " + entry.getValue());
//                    }
                }
//                System.out.println("---------------");
                HashMap<Pair, Integer> v = new HashMap<>();
                for (int i = 0; i < nr_stele-1; i ++){
                    for (int j = i + 1; j < nr_stele; j ++){
                        Pair p = new Pair (Math.abs (x [j] - x [i]), Math.abs (y [j] - y [i]));
                        if (v.containsKey(p)) {
                            v.put(p, v.get(p) + 1);
                        }
                        else {
                            v.put(p, 1);
                        }
                        if(v.get(p)>=3){
                            ok = 1;
                            break;
                        }
                    }
                    if (ok == 1)break;
                }
                if (ok == 1)
                    out.write("DA\n");
                else
                    out.write("NU\n");
                for (Map.Entry<Pair, Integer> entry : v.entrySet())
                {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
