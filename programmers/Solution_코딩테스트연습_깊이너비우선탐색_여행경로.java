package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_코딩테스트연습_깊이너비우선탐색_여행경로 {

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "ABC"}, {"HND", "ICN"}, {"ABC", "HND"}};
        String[][] tickets = {{"ICN", "ABC"}, {"ICN", "ABC"}, {"ABC", "ICN"}, {"ABC", "HHH"}};
//        String[][] tickets = {{"ICN", "A"}, {"A", "ICN"}, {"ICN", "A"}, {"A", "B"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        solution(tickets);
    }

    public static int[] visit;
    public static List<String> tmp = new ArrayList<>();
    public static String[] answer = null;
    public static boolean flag = false;

    public static String[] solution(String[][] tickets) {
        List<Trip> list = new ArrayList<>();
        for (int i = 0; i < tickets.length; ++i) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            list.add(new Trip(start, end));
        }
        list.sort(Comparator.comparing(Trip::getStart).thenComparing(Trip::getEnd));
        visit = new int[list.size()];
        int start = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).start.equals("ICN")) {
                start = i;
                break;
            }
        }
        tmp.add(list.get(start).start);
        tmp.add(list.get(start).end);
        visit[start] = 1;
        dfs(list);

        return answer;
    }

    private static void dfs(List<Trip> list) {
        if (tmp.size() == list.size() + 1) {
            if (!flag) {
                flag = true;
                answer = tmp.toArray(new String[0]);
                System.out.println("answer = " + Arrays.toString(answer));
            }
            return;
        }

        for (int i = 0; i < list.size(); ++i) {
            if (visit[i] == 1) continue;
            if (tmp.get(tmp.size() - 1).equals(list.get(i).start)) {
                visit[i] = 1;
                tmp.add(list.get(i).end);
                dfs(list);
                visit[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static class Trip {
        private String start;
        private String end;

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }

        public Trip(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
