package hr.fer.oop.labosi.samostalni;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Solution {

    public static Predicate<List<List<Integer>>> allDigitsMatch(double exemplar){
        String broj = Double.toString(exemplar);

        return (list -> {
           for (List<Integer> pair : list) {

               int index;
               if (pair.get(0) == 0) index = 0;
               else index = pair.get(0) + 1;
               if (index < broj.length()) {
                   String brojka = pair.get(1).toString();
                   if (!broj.contains(brojka)) return false;
               }
           }
            return true;
        });
    }

    public static Predicate<List<List<Integer>>> allDigitsDefined(){
        return (list ->  {
            Set<Integer> indexi = new TreeSet<>();
            for (List<Integer> pair : list) {
                indexi.add(pair.get(0));
            }

            for (int i = 0; i < indexi.size(); i++) {
                if (!indexi.contains(i)) return false;
            }
            return true;
        });
    }

}
