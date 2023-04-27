package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_완전탐색_전력망을둘로나누기 {

    public static int answer = 0;

    public static int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; ++i) {
            go(i, wires, n);
        }

        return answer;
    }

    private static void go(int index, int[][] wires, int n) {

        int[] visit = new int[n];
        Arrays.fill(visit, 0);

        for (int i = 0; i < wires.length; ++i) {
            if (index == i) {
                continue;
            }

            int node1 = wires[i][0] - 1;
            int node2 = wires[i][1] - 1;

            // 둘 다 방문한 경우
            if (visit[node1] != 0 && visit[node2] != 0) {
                continue;
            }

            // 둘 다 방문 안한경우
            if (visit[node1] == visit[node2] && visit[node1] == 0) {
                int fillWith = Arrays.stream(visit).boxed().collect(Collectors.toList()).contains(1) ? 2 : 1;
                visit[node1] = fillWith;
                visit[node2] = fillWith;
                continue;
            }

            if (visit[node1] == 0) {
                visit[node1] = visit[node2];
                continue;
            }

            if (visit[node2] == 0) {
                visit[node2] = visit[node1];
            }
        }

        calculate(visit);
    }

    private static void calculate(int[] visit) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : visit) {
            if (num == 0) count0++;
            if (num == 1) count1++;
            if (num == 2) count2++;
        }

        int tmp = Math.max(count0, count1) - Math.min(count0, count1);
        int result = Math.abs(tmp - count2);
        answer = Math.min(answer, result);
    }

    public static void main(String[] args) {
//        int n = 9;
//        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//        int n = 4;
//        int[][] wires = {{1,2},{2,3},{3,4}};
        int n = 7;
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        solution(n, wires);
    }

}
