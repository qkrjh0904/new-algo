package programmers;

import java.util.ArrayList;
import java.util.List;

public class Algo_조합 {

    public static void main(String[] args) {
        // n개 중 r개를 뽑기 (순서 상관 없음)
        List<Integer> list = new ArrayList();
        combination(0, list);
    }

    static int n = 5;
    static int r = 3;
    static int[] visit = new int[n];
    static int cnt = 1;

    private static void combination(int now, List<Integer> list) {
        if (list.size() == r) {
            System.out.println(list + " cnt=" + cnt++);
            return;
        }

        for (int i = now; i < n; ++i) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            list.add(i);
            combination(i, list);
            list.remove(list.size() - 1);
            visit[i] = 0;
        }

    }

}
