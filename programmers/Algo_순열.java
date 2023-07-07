package programmers;

import java.util.ArrayList;
import java.util.List;

public class Algo_순열 {

    public static void main(String[] args) {
        // n개 중 r개를 뽑아서 나열 (순서 있음)
        List<Integer> list = new ArrayList();
        permutation(list);
    }

    static int n = 5;
    static int r = 3;
    static int[] visit = new int[n];
    static int cnt = 1;

    private static void permutation(List<Integer> list) {
        if (list.size() == r) {
            System.out.println(list + " cnt=" + cnt++);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            list.add(i);
            permutation(list);
            list.remove(list.size() - 1);
            visit[i] = 0;
        }

    }

}
