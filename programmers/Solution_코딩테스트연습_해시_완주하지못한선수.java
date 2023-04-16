package programmers;

import java.util.HashMap;
import java.util.Set;

public class Solution_코딩테스트연습_해시_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        String answer = "";
        Set<String> keySet = map.keySet();
        for (String name : keySet) {
            if (map.get(name).equals(1)) {
                answer = name;
                break;
            }
        }

        return answer;
    }
}
