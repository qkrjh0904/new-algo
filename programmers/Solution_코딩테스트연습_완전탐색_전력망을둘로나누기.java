package programmers;

import java.util.Arrays;

public class Solution_코딩테스트연습_완전탐색_전력망을둘로나누기 {

    public static int answer = 100;
    public static int[] parent;

    public static void main(String[] args) {
//        int n = 9;
//        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//        int n = 4;
//        int[][] wires = {{1,2},{2,3},{3,4}};
//        int n = 2;
//        int[][] wires = {{1, 2}};
        int n = 7;
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        solution(n, wires);
    }

    public static int solution(int n, int[][] wires) {
        for (int i = 0; i < wires.length; ++i) {
            go(i, n, wires);
        }

        return answer;
    }

    private static void go(int index, int n, int[][] wires) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < wires.length; ++i) {
            if (i == index)
                continue;

            int node1 = wires[i][0] - 1;
            int node2 = wires[i][1] - 1;

            union(node1, node2);
        }
        count();
    }

    private static void count() {
        int p1 = parent[0];
        int cnt = 0;
        for (int i = 0; i < parent.length; ++i) {
            if (parent[i] == p1) {
                cnt++;
            } else {
                cnt--;
            }
        }
        System.out.println(Math.abs(cnt));
        answer = Math.min(answer, Math.abs(cnt));
    }

    private static void union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);

        if (p1 < p2) {
            parent[p2] = p1;
            return;
        }
        parent[p1] = p2;
    }

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

}
