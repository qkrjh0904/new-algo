package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_깊이너비우선탐색_단어변환 {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        solution(begin, target, words);
    }

    public static int answer = 100;
    public static int[] visit;

    public static int solution(String begin, String target, String[] words) {
        List<String> list = Arrays.stream(words).collect(Collectors.toList());
        if (!list.contains(target)) {
            return 0;
        }

        visit = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            boolean changeAble = isDifferentOnlyOne(begin, list.get(i));
            if (changeAble) {
                System.out.println(begin + " " + list.get(i));
                visit[i] = 1;
                dfs(list.get(i), list, target, 1);
                visit[i] = 0;
            }
        }


        return answer;
    }

    private static void dfs(String now, List<String> list, String target, int cnt) {
        if (cnt > list.size()) {
            return;
        }
        if (now.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < list.size(); ++i) {
            if (visit[i] == 1) {
                continue;
            }
            boolean changeAble = isDifferentOnlyOne(now, list.get(i));
            if (changeAble) {
                visit[i] = 1;
                dfs(list.get(i), list, target, cnt + 1);
                visit[i] = 0;
            }
        }
    }

    private static boolean isDifferentOnlyOne(String begin, String word) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
