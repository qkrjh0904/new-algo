package programmers;

public class Solution_코딩테스트연습_완전탐색_카펫 {

    public static int[] solution(int brown, int yellow) {
        if (yellow == 1) {
            return new int[]{3, 3};
        }

        int aPlusB = (brown - 4) / 2;
        for (int i = 1; i <= yellow / 2; ++i) {
            if ((yellow % i) != 0) {
                continue;
            }

            int a = i;
            int b = yellow / i;
            if (aPlusB == (a + b)) {
                return new int[]{b + 2, a + 2};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        solution(14, 4);
    }

}
