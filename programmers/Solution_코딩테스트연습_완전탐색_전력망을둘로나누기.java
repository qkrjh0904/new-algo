package programmers;

import java.util.Arrays;

public class Solution_코딩테스트연습_완전탐색_전력망을둘로나누기 {

    public static int answer = 100;
    public static boolean[] visit;

    public static int[][] map;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//        int n = 4;
//        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
//        int n = 2;
//        int[][] wires = {{1, 2}};
//        int n = 7;
//        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        solution(n, wires);
    }

    public static int solution(int n, int[][] wires) {
        for (int i = 0; i < wires.length; ++i) {
            visit = new boolean[n];
            setMap(i, n, wires);
//            print(n);
            dfs(0, n);
            int count = count();
            answer = Math.min(Math.abs(count - (n - count)), answer);
        }
        System.out.println(answer);
        return answer;
    }

    private static int count() {
        int cnt = 0;
        for (boolean b : visit) {
            if (b) cnt++;
        }
        return cnt;
    }

    private static void dfs(int i, int n) {
        if (visit[i]) {
            return;
        }

        visit[i] = true;
        for (int j = 0; j < n; ++j) {
            if (i == j) continue;

            if (!visit[j] && map[i][j] == 1) {
                dfs(j, n);
            }
        }
    }

    private static void setMap(int except, int n, int[][] wires) {
        map = new int[n][n];

        for (int i = 0; i < wires.length; ++i) {
            if (i == except) continue;

            int n1 = wires[i][0] - 1;
            int n2 = wires[i][1] - 1;

            map[n1][n2] = 1;
            map[n2][n1] = 1;
        }
    }

    private static void print(int n) {
        for (int i = 0; i < n; ++i) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

}
