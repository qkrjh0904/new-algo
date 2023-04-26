package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_코딩테스트연습_완전탐색_피로도 {

    private static List<Dungeon> dungeonList = new ArrayList<>();
    private static Integer answer = 0;
    private static int[] visit = new int[8];

    public static class Dungeon {
        public Integer minEnergy;
        public Integer needEnergy;

        public static Dungeon of(Integer minEnergy, Integer needEnergy) {
            Dungeon dungeon = new Dungeon();
            dungeon.minEnergy = minEnergy;
            dungeon.needEnergy = needEnergy;
            return dungeon;
        }
    }

    public static int solution(int k, int[][] dungeons) {
        for (int[] dungeon : dungeons) {
            dungeonList.add(Dungeon.of(dungeon[0], dungeon[1]));
        }

        go(new ArrayList<>(), dungeonList.size(), k);

        return answer;
    }

    private static void go(List<Integer> now, int limit, int k) {
        if (now.size() == limit) {
            check(now, k);
            return;
        }

        for (int i = 0; i < limit; ++i) {
            if (visit[i] == 0) {
                visit[i] = 1;
                now.add(i);
                go(now, limit, k);
                now.remove(now.size() - 1);
                visit[i] = 0;
            }
        }
    }

    private static void check(List<Integer> now, int k) {
        int cnt = 0;
        for (Integer index : now) {
            Dungeon dungeon = dungeonList.get(index);
            if (k >= dungeon.minEnergy) {
                k -= dungeon.needEnergy;
                cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }

    public static void main(String[] args) {
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        solution(80, dungeons);
    }

}
