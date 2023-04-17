package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_코딩테스트연습_해시_위장 {

    // (1번 의상개수 + 1) * (2번 의상개수 + 1) * (3번 의상개수 + 1) * ... * (n번 의상개수 + 1) -1
    public static int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; ++i) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        List<Integer> list = new ArrayList<>(map.values());
        for (Integer num : list) {
            answer *= (num + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

}
