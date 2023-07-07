package programmers;

import java.util.ArrayList;
import java.util.List;

public class Algo_순열_중복허용 {

    public static void main(String[] args) {
        // n개 중 r개를 뽑아서 나열 (중복 허용, 순서 있음)
        List<Integer> list = new ArrayList();
        permutation(list);
    }

    static int n = 5;
    static int r = 3;
    static int cnt = 1;

    private static void permutation(List<Integer> list) {
        if (list.size() == r) {
            System.out.println(list + " cnt=" + cnt++);
            return;
        }

        for (int i = 0; i < n; ++i) {
            list.add(i);
            permutation(list);
            list.remove(list.size() - 1);
        }

    }

}
