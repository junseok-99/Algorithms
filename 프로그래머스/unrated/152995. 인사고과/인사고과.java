import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int[] wanho = scores[0];
        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        
        int maxFriend = -1;
        
        for(int[] score: scores) {
            
            if (score[1] > maxFriend) {
                maxFriend = score[1];
            } else if (score[1] < maxFriend) {
                if (score[0] == wanho[0] && score[1] == wanho[1]) {
                    return -1;
                }
                continue;
            }
            
            if (score[0] + score[1] > wanho[0] + wanho[1]) {
                answer++;
            }
        }
        
        return answer;
    }
}