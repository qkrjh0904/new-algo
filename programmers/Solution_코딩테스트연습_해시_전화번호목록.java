package programmers;

import java.util.Arrays;

public class Solution_코딩테스트연습_해시_전화번호목록 {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; ++i) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean answer = solution(new String[]{"12", "123", "1235", "567", "88", "121", "122"});
        System.out.println(answer);
    }
}
