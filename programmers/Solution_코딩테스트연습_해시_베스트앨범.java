package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_코딩테스트연습_해시_베스트앨범 {

    public static class GenreInfo {
        private String genre;
        private List<GenreIndex> genreIndexList;
        private Integer sum;

        public Integer getSum() {
            return sum;
        }

        public void sortGenreIndexList() {
            genreIndexList = genreIndexList.stream()
                    .sorted(Comparator.comparing(GenreIndex::getPlay).reversed())
                    .collect(Collectors.toList());
        }

        public static GenreInfo of(String genre, List<GenreIndex> genreIndexList, Integer sum) {
            GenreInfo genreInfo = new GenreInfo();
            genreInfo.genre = genre;
            genreInfo.genreIndexList = genreIndexList;
            genreInfo.sum = sum;
            return genreInfo;
        }

        public static class GenreIndex {
            private Integer index;
            private Integer play;

            public static GenreIndex of(Integer index, Integer play) {
                GenreIndex genreIndex = new GenreIndex();
                genreIndex.index = index;
                genreIndex.play = play;
                return genreIndex;
            }

            public Integer getPlay() {
                return play;
            }
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, GenreInfo> map = new HashMap<>();
        for (int i = 0; i < genres.length; ++i) {
            setMap(map, genres[i], i, plays[i]);
        }

        // 정렬
        List<GenreInfo> genreInfoList = new ArrayList<>(map.values()).stream()
                .sorted(Comparator.comparing(GenreInfo::getSum).reversed())
                .collect(Collectors.toList());
        genreInfoList.forEach(GenreInfo::sortGenreIndexList);

        ArrayList<Integer> answer = new ArrayList<>();
        for (GenreInfo genreInfo : genreInfoList) {
            List<GenreInfo.GenreIndex> genreIndexList = genreInfo.genreIndexList;
            answer.add(genreIndexList.get(0).index);
            if(genreIndexList.size()>1){
                answer.add(genreIndexList.get(1).index);
            }
        }

        return answer.stream()
                .mapToInt(i->i)
                .toArray();
    }

    private static void setMap(Map<String, GenreInfo> map, String genre, int i, int play) {
        if (map.containsKey(genre)) {
            GenreInfo genreInfo = map.get(genre);
            genreInfo.sum += play;
            genreInfo.genreIndexList.add(GenreInfo.GenreIndex.of(i, play));
            return;
        }

        ArrayList<GenreInfo.GenreIndex> genreIndexList = new ArrayList<>();
        genreIndexList.add(GenreInfo.GenreIndex.of(i, play));
        GenreInfo genreInfo = GenreInfo.of(genre, genreIndexList, play);
        map.put(genre, genreInfo);
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] play = {500, 600, 150, 800, 2500};
        solution(genres, play);
    }

}
