import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int sum, len = elements.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        
        for(int i=0;i<elements.length;i++){
            sum = 0;
            for(int j=0;j<elements.length;j++){
                sum += elements[(i+j)%len];
                hs.add(sum);
            }
        }
        return hs.size();
    }
}