package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    class Solution {
        public int romanToInt(String s) {

            Map<String, Integer> map = getMap();

            String[] arr = s.split("");
            int sum = Arrays.stream(arr)
                    .mapToInt(map::get)
                    .sum();

            for (int i = 0; i < arr.length - 1; ++i) {
                sum -= getValue(arr[i], arr[i + 1]);
            }
            return sum;
        }

        public int getValue(String s1, String s2) {
            if (s1.equals("I") && (s2.equals("V") || s2.equals("X"))) {
                return 2;
            }

            if (s1.equals("X") && (s2.equals("L") || s2.equals("C"))) {
                return 20;
            }

            if (s1.equals("C") && (s2.equals("D") || s2.equals("M"))) {
                return 200;
            }

            return 0;
        }

        public Map<String, Integer> getMap() {
            Map<String, Integer> map = new HashMap<>();
            map.put("I", 1);
            map.put("V", 5);
            map.put("X", 10);
            map.put("L", 50);
            map.put("C", 100);
            map.put("D", 500);
            map.put("M", 1000);
            return map;
        }
    }
}
