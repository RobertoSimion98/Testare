package pachet1;

import java.util.HashMap;

public class MyClass {
    public static void Plagiat(String[] arg) {
        System.out.println("---------------------------------------------------------");
        int ok=0,count_arg=0,fail=0;
        int nr_harti = Integer.parseInt(arg[count_arg]);
        count_arg++;
        if(nr_harti < 1 || nr_harti >= 6){
            System.out.println("Numarul de harti trebuie sa fie intre [1,5]");
            return;
        }

        for (int t = 0; t < nr_harti; t ++){
            fail=0;
            if(arg[count_arg]==null){
                System.out.println("Nu pot exista argumente de tipul 'null'");return;
            }
            int nr_stele = Integer.parseInt(arg[count_arg]);
            count_arg++;
            if(nr_stele < 1 || nr_stele >= 201) {
                System.out.println("Numarul de stele trebuie sa fie intre [1,200]");
                continue;
            }

            int[] x = new int[nr_stele];
            int[] y = new int[nr_stele];
            ok=0;

            HashMap<Pair, Integer> coordonate = new HashMap<>();
            for (int i = 0; i < nr_stele; i ++){
                x[i]=Integer.parseInt(arg[count_arg]);
                count_arg++;
                y[i]=Integer.parseInt(arg[count_arg]);
                count_arg++;
                if(x[i] < 0 || x[i] > 109){
                    System.out.println("Coordonatele stelelor trebuie sa fie intre [0,109]");
                    fail=1;
                    continue;
                }

                if(y[i] < 0 || y[i] > 109){
                    System.out.println("Coordonatele stelelor trebuie sa fie intre [0,109]");
                    fail=1;
                    continue;
                }
                Pair p = new Pair (x[i],y[i]);
                if (coordonate.containsKey(p)) {
                    coordonate.put(p, coordonate.get(p) + 1);
                }
                else {
                    coordonate.put(p, 1);
                }
                if(coordonate.get(p)>1){
                    System.out.println("Nu pot exista două stele cu aceleaşi coordonate: " +p);
                    fail=1;
                    continue;
                }
//                    for (Map.Entry<Pair, Integer> entry : coordonate.entrySet())
//                    {
//                        System.out.println(entry.getKey() + " " + entry.getValue());
//                    }
            }
            if(fail==1){
                continue;
            }
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
                    if(v.get(p)>2){
                        ok = 1;
                        break;
                    }
                }
                if (ok == 1)break;
            }
            if (ok == 1)
                System.out.println("DA");
            else
                System.out.println("NU");
//                for (Map.Entry<Pair, Integer> entry : v.entrySet())
//                {
//                    System.out.println(entry.getKey() + " " + entry.getValue());
//                }

        }
    }
}
