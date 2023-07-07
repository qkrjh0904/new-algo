package programmers;

import java.util.ArrayList;
import java.util.List;

public class Algo_조합_중복허용 {

    public static void main(String[] args) {
        // n개 중 r개를 뽑기 (순서 상관 없음, 중복 허용)
        List<Integer> list = new ArrayList();
        combination(0, list);
    }

    static int n = 5;
    static int r = 3;
    static int cnt = 1;

    private static void combination(int now, List<Integer> list) {
        if (list.size() == r) {
            System.out.println(list + " cnt=" + cnt++);
            return;
        }

        for (int i = now; i < n; ++i) {
            list.add(i);
            combination(i, list);
            list.remove(list.size() - 1);
        }

    }
    
}
