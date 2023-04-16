package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_코딩테스트연습_해시_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
                continue;
            }
            map.put(name, 1);
        }

        for (String name : completion) {
            if (map.containsKey(name)) {
                if (map.get(name).equals(1)) {
                    map.remove(name);
                    continue;
                }
                map.put(name, map.get(name) - 1);
            }
        }

        return new ArrayList<>(map.keySet()).get(0);
    }
}
