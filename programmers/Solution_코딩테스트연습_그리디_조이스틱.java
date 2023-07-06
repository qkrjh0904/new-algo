package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution_코딩테스트연습_그리디_조이스틱 {

    public static void main(String[] args) {
//        solution("JEROEN");
//        solution("JAN");
//        solution("BAABA");
//        solution("BAAA");
        solution("ABAAAAAAAB");
    }

    public static Map<String, Integer> map = new HashMap<>();
    public static int answer = 0;

    public static int solution(String name) {
        setting();
        String[] nameSplit = name.split("");
        for (String nameAlpha : nameSplit) {
            answer += map.get(nameAlpha);
        }

        int min = Math.min(goRight(nameSplit), goLeft(nameSplit));
        answer += min;
        System.out.println(answer);
        return answer;
    }

    private static int goLeft(String[] nameSplit) {
        int sum = 0;
        int tmp = 1;
        for (int i = nameSplit.length - 1; i > 0; --i) {
            if (nameSplit[i].equals("A")) {
                tmp++;
                continue;
            }
            sum += tmp;
            tmp = 1;
        }
        return sum;
    }

    private static int goRight(String[] nameSplit) {
        int sum = 0;
        int tmp = 1;
        for (int i = 1; i < nameSplit.length; ++i) {
            if (nameSplit[i].equals("A")) {
                tmp++;
                continue;
            }
            sum += tmp;
            tmp = 1;
        }
        return sum;
    }

    private static void setting() {
        map.put("A", 0);
        map.put("B", 1);
        map.put("C", 2);
        map.put("D", 3);
        map.put("E", 4);
        map.put("F", 5);
        map.put("G", 6);
        map.put("H", 7);
        map.put("I", 8);
        map.put("J", 9);
        map.put("K", 10);
        map.put("L", 11);
        map.put("M", 12);
        map.put("N", 13);
        map.put("O", 12);
        map.put("P", 11);
        map.put("Q", 10);
        map.put("R", 9);
        map.put("S", 8);
        map.put("T", 7);
        map.put("U", 6);
        map.put("V", 5);
        map.put("W", 4);
        map.put("X", 3);
        map.put("Y", 2);
        map.put("Z", 1);
    }
}
