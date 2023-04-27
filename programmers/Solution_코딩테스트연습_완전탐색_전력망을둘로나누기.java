package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_코딩테스트연습_완전탐색_전력망을둘로나누기 {

    public static int answer = 0;

    public static int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; ++i) {
            go2(i, wires, n);
        }

        System.out.println(answer);
        return answer;
    }

    private static void go2(int index, int[][] wires, int n) {

        int[] parent = getParentArray(n);
        for (int i = 0; i < wires.length; ++i) {
            if (index == i) {
                continue;
            }

            int n1 = wires[i][0] - 1;
            int n2 = wires[i][1] - 1;

            union(parent, n1, n2);
        }

        count(parent, n);
    }

    private static void count(int[] parent, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int num = parent[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        System.out.println(list);
        answer = Math.min(answer, Math.abs(list.get(0) - list.get(1)));
    }

    private static void union(int[] parent, int n1, int n2) {
        n1 = getParent(parent, n1);
        n2 = getParent(parent, n2);
        if (n1 > n2) {
            parent[n1] = n2;
            return;
        }
        parent[n2] = n1;
    }

    private static int getParent(int[] parent, int n1) {
        if (parent[n1] == n1) {
            return n1;
        }
        return parent[n1] = getParent(parent, parent[n1]);
    }

    private static int[] getParentArray(int n) {
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        return parent;
    }

    public static void main(String[] args) {
//        int n = 9;
//        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
//        int n = 4;
//        int[][] wires = {{1,2},{2,3},{3,4}};
        int n = 7;
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
//        int n = 2;
//        int[][] wires = {{1, 2}};
        solution(n, wires);
    }

}
