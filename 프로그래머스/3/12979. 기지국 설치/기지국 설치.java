class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        
        for(int stat: stations) {
            int length = (stat - w) - start;
            if (length > 0) {
                answer += InitStation(length, 2 * w + 1);
            }
            start = stat + w + 1;
        }
        
        if (start <= n) {
            int length = n - start + 1;
            answer += InitStation(length, 2 * w + 1);
        }
        
        return answer;
    }
    
    public int InitStation(int len, int w) {
        
        int station = len / w;
        
        if (len % w != 0) {
            station++;
        }
        
        return station;
    }
}