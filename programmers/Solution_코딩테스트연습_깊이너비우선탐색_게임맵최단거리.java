package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_코딩테스트연습_깊이너비우선탐색_게임맵최단거리 {

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
//        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        solution(maps);
    }


    public static int answer;
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};
    public static int R, C;
    public static int[][] visit;

    public static int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        visit = new int[R][C];
        visit[0][0] = 1;
        bfs(maps);
        return answer > 0 ? answer : -1;
    }

    private static void bfs(int[][] maps) {

        Queue<Location> queue = new LinkedList<>();
        queue.add(Location.of(0, 0));

        int level = 1;
        loop:
        while (!queue.isEmpty()) {
            level++;
            print();
            int qSize = queue.size();
            for (int j = 0; j < qSize; ++j) {
                Location location = queue.poll();
                int r = location.r;
                int c = location.c;
                for (int i = 0; i < 4; ++i) {
                    int tr = r + dr[i];
                    int tc = c + dc[i];

                    // 맵 벗어나는 경우, 이미 방문한 경우, 벽인 경우
                    if (tr < 0 || tc < 0 || tr >= R || tc >= C || visit[tr][tc] == 1 || maps[tr][tc] == 0)
                        continue;

                    visit[tr][tc] = 1;
                    queue.add(Location.of(tr, tc));
                    if (tr == R - 1 && tc == C - 1) {
                        answer = level;
                        break loop;
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < visit.length; ++i) {
            System.out.println(Arrays.toString(visit[i]));
        }
        System.out.println();
    }

    static class Location {
        int r, c;

        public static Location of(int r, int c) {
            Location location = new Location();
            location.r = r;
            location.c = c;
            return location;
        }
    }
}
