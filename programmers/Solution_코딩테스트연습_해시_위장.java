package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_코딩테스트연습_해시_위장 {

    public static int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; ++i) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());



        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

}
