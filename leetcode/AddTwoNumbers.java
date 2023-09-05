package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {

//        List<Integer> list1 = List.of(9, 9, 9, 9, 9, 9, 9);
//        List<Integer> list2 = List.of(9, 9, 9, 9);

        List<Integer> list1 = List.of(2, 4, 3);
        List<Integer> list2 = List.of(5, 6, 4);

//        List<Integer> list1 = List.of(0);
//        List<Integer> list2 = List.of(0);

        List<Integer> result = solution(list1, list2);
        System.out.println(result);
    }

    private static List<Integer> solution(List<Integer> list1, List<Integer> list2) {
        int min = Math.min(list1.size(), list2.size());

        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < min; ++i) {
            sums.add(list1.get(i) + list2.get(i));
        }

        fillNumber(min, sums, list1);
        fillNumber(min, sums, list2);

        int nextNumber = 0;
        for (int i = 0; i < sums.size(); ++i) {
            int number = sums.get(i) + nextNumber;
            if (number >= 10) {
                int mod = number % 10;
                nextNumber = number / 10;
                sums.set(i, mod);
            } else {
                sums.set(i, number);
                nextNumber = 0;
            }
        }


        if (nextNumber > 0) {
            sums.add(nextNumber);
        }

        return sums;
    }

    private static void fillNumber(Integer min, List<Integer> sums, List<Integer> list) {
        if (list.size() > min) {
            for (int i = min; i < list.size(); ++i) {
                sums.add(list.get(i));
            }
        }
    }

}
