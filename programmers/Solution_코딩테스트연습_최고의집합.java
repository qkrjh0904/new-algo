package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_코딩테스트연습_최고의집합 {

    public static int MAX = 0;
    public static int[] answer = {-1};

    public static void main(String[] args) {
        solution(2, 5);
    }

    public static int[] solution(int n, int s) {
        List<Integer> list = new ArrayList<>();
        go(list, n, s, 1);

        return answer;
    }

    private static void go(List<Integer> list, int n, int s, int num) {
        if(list.size() == n){
            if(list.stream().mapToInt(Integer::intValue).sum() == s){
                System.out.println(list);
                Integer result = list.stream().reduce(1, (a, b) -> a * b);
                if(MAX < result){
                    MAX = result;
                    answer = list.stream().mapToInt(Integer::intValue).toArray();
                }
            }
            return;
        }

        for (int i = num; i <= s; i++) {
            list.add(i);
            go(list, n, s, i);
            list.remove(list.size() - 1);
        }
    }

}
