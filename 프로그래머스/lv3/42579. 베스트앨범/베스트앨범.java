import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, List<int[]>> rankMap = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<genres.length;i++) {
            genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i]);
            set.add(genres[i]);
            
            if (!rankMap.containsKey(genres[i])) {
                rankMap.put(genres[i], new ArrayList<>());
            }
            rankMap.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        List<String> li = new ArrayList<>(set);
        Collections.sort(li, (s1, s2) -> genresMap.get(s2) - genresMap.get(s1));
        
        for(String genre: li) {
            Collections.sort(rankMap.get(genre), (o1, o2) -> o2[0] - o1[0]);
            for(int i=0;i<2 && i<rankMap.get(genre).size();i++) {
                answer.add(rankMap.get(genre).get(i)[1]);
            }
        }
        return answer;
    }
}