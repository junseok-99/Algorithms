import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] counts = new int[n + 1];
        Set<String> set = new HashSet<>();
        char prev = '-';
        int idx = 0;
        
        for (String word : words) {
            int num = idx % n + 1; 
            counts[num]++;   
            if (set.contains(word) || (prev != '-' && prev != word.charAt(0))) {
                return new int[]{num, counts[num]};
            } 
            set.add(word);
            idx++;
            prev = word.charAt(word.length() - 1);
        }
        return new int[]{0, 0};
    }
}