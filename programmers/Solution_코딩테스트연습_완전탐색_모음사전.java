package programmers;

import java.util.List;

public class Solution_코딩테스트연습_완전탐색_모음사전 {

    public static int cnt = 0;
    public static int answer = 0;
    public static boolean flag = false;

    public static int solution(String word) {
        List<String> list = List.of("A", "E", "I", "O", "U");

        for (int i = 0; i < list.size(); ++i) {
            go(word, list, list.get(i));
        }
        return answer;
    }

    private static void go(String word, List<String> list, String s) {
        if (flag || s.length() > 5) {
            return;
        }
        cnt++;
        if (s.equals(word)) {
            flag = true;
            answer = cnt;
        }
//        System.out.println(s + " : " + cnt);
        for (int i = 0; i < list.size(); ++i) {
            s = s + list.get(i);
            go(word, list, s);
            s = s.substring(0, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        solution("AAAAE");
    }

}
