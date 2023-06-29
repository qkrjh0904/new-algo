package programmers;

import java.util.Arrays;

public class Solution_코딩테스트연습_깊이너비우선탐색_네트워크 {

    static int[] visit;
    static int answer = 0;

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int n = 3;
        solution(n, computers);
    }

    public static int solution(int n, int[][] computers) {
        visit = new int[n];

        for (int i = 0; i < n; ++i) {
            if (visit[i] == 1) {
                continue;
            }
            dfs(i, computers);
            print();
            answer++;
        }

        return answer;
    }

    private static void dfs(int index, int[][] computers) {
        visit[index] = 1;
        for (int i = 0; i < computers.length; ++i) {
            if (i == index) continue;

            if (visit[i] == 0 && computers[index][i] == 1) {
                dfs(i, computers);
            }
        }
    }

    private static void print() {
        System.out.println(Arrays.toString(visit));
    }

}
