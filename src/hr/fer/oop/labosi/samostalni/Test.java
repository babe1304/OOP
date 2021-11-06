package hr.fer.oop.labosi.samostalni;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
//        List<List<Integer>> ulaz1= Arrays.asList(Arrays.asList(1,2),Arrays.asList(0,3),Arrays.asList(2,6)); // 3.26
//
//        boolean t1 = Solution.allDigitsMatch(3.266).test(ulaz1); // true
//        boolean t2 = Solution.allDigitsDefined().test(ulaz1); // true
//        System.out.println(t1);
//        System.out.println(t2);
//
//        List<List<Integer>> ulaz2= Arrays.asList(Arrays.asList(1,2),Arrays.asList(0,3),Arrays.asList(4,6)); // 3.2**6
//        boolean t3 = Solution.allDigitsMatch(3.266).test(ulaz2); // true
//        System.out.println(t3);
//        boolean t4 = Solution.allDigitsDefined().test(ulaz2); // false
//        System.out.println(t4);

        Iterator<Integer> iterator = new FactorialIterator(0);
        while(iterator.hasNext())
            System.out.println(iterator.next());

        try {
            Iterator<Integer> iterator2 = new FactorialIterator(-1);
            while(iterator2.hasNext())
                System.out.println(iterator2.next());
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }


}
