package programmers;

public class Solution_코딩테스트연습_완전탐색_최소직사각형 {

    public static int solution(int[][] sizes) {

        int length = 0;
        int height = 0;

        for (int[] size : sizes) {
            length = Math.max(length, Math.max(size[0], size[1]));
            height = Math.max(height, Math.min(size[0], size[1]));
        }

        return length * height;
    }

    public static void main(String[] args) {
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        solution(sizes);
    }

}
