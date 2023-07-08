package toss;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Question2 {

    public static void main(String[] args) {

        int[][] relationships = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
        solution(relationships, 2, 3);
    }

    public static int coin = 0;
    public static int newFriendsNum = 0;
    public static int[][] map;
    public static int[] visit;
    public static int N;

    public static int solution(int[][] relationships, int target, int limit) {
        setMap(relationships);
        bfs(target, limit);

        int answer = coin + newFriendsNum;
        System.out.println(answer);
        return answer;
    }

    private static void bfs(int target, int limit) {
        visit = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target - 1);
        visit[target - 1] = 1;

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            if (level > limit) {
                break;
            }

            int qSize = queue.size();
            for (int i = 0; i < qSize; ++i) {

                int row = queue.poll();
                for (int j = 0; j < N; ++j) {
                    int isFriend = map[row][j];
                    if (isFriend == 0 || visit[j] == 1) {
                        continue;
                    }

                    visit[j] = 1;
                    queue.add(j);
                }
            }

            if (level == 1) {
                coin += queue.size() * 5;
            }

            if (level > 1) {
                coin += queue.size() * 10;
                newFriendsNum += queue.size();
            }

            System.out.println("queue : " + queue);
            System.out.println("queueSize : " + queue.size());
            System.out.println("coin : " + coin);
            System.out.println("newFriendsNum : " + newFriendsNum);
        }
    }

    private static void setMap(int[][] relationships) {
        N = getMaxSize(relationships);
        map = new int[N][N];

        for (int[] relationship : relationships) {
            int node1 = relationship[0] - 1;
            int node2 = relationship[1] - 1;
            map[node1][node2] = 1;
            map[node2][node1] = 1;
        }
    }

    private static int getMaxSize(int[][] relationships) {
        int max = 0;
        for (int[] relationship : relationships) {
            max = Math.max(max, relationship[0]);
            max = Math.max(max, relationship[1]);
        }
        return max;
    }

    private static void print() {
        for (int i = 0; i < N; ++i) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
