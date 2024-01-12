package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_코딩테스트연습_이중우선순위큐 {

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        solution(operations);
    }

    public static int[] solution(String[] operations) {

        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int num = Integer.parseInt(split[1]);

            if (command.equals("I")) {
                list.add(num);
                list.sort(Integer::compareTo);
                continue;
            }

            if(num == 1 && !list.isEmpty()){
                list.remove(list.size() - 1);
                continue;
            }

            if(!list.isEmpty()){
                list.remove(0);
            }
        }

        if(list.isEmpty()){
            return new int[]{0, 0};
        }
        if(list.size() == 1){
            return new int[]{list.get(0), list.get(0)};
        }
        return new int[]{list.get(list.size() - 1), list.get(0)};
    }
}
