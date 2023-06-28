package programmers;

public class Algo_Permutation {

    public static int answer = 100;
    public static int[] parent;

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
