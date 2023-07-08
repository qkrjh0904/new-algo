package toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Question3 {

    public static void main(String[] args) {

        String[] arr = {"토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"};
//        String[] arr = {"비바리퍼블리", "토스커피사일로 베이커리", "비바리퍼블리카 식당", "토스커피사일", "토스커피사일로 베이커", "비바리퍼블리카식", "토스커피사일로 베이", "토스커피사일로&베이커리"};
        solution(arr);
    }

    public static Set<String> specialSet = Set.of("&", "(", ")", ".", ",", "-");
    public static List<String> answerList = new ArrayList<>();


    public static String[] solution(String[] merchantNames) {
        List<String> list = Arrays.stream(merchantNames).collect(Collectors.toList());
        for (String name : list) {
            if (answerList.isEmpty()) {
                answerList.add(name);
                continue;
            }

            // 다른 상호명이라면 상호명 반환
            // 한쪽이 포함된다면 대표 상호면 반환
            String newName = check(name);
            if (Objects.nonNull(newName)) {
                answerList.add(newName);
                answerList.remove(name);
            }
        }


        return answerList.toArray(new String[0]);
    }

    private static String check(String name) {
        for (String s : answerList) {
            if (s.startsWith(name)) {
                return null;
            }
        }

        // 공백을 제외한 길이 비교



        // 특수문자 개수
        for (String special : specialSet) {

        }


        return name;
    }

}
