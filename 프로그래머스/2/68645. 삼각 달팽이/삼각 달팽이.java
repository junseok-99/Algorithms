class Solution {
    public int[] solution(int n) {
        int sum = n*(n+1)/2;
        int num = 1;
        int[] answer = new int[sum];
        int[][] map = new int[n][];
        
        for(int i=0;i<n;i++)
            map[i] = new int[i+1];
        
        int x=0, y=-1;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i%3 == 0)
                    y++;
                else if(i%3 == 1)
                    x++;
                else{
                    y--;
                    x--;
                }
                map[y][x] = num++;
            }
        }
        
        int idx = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<i+1;j++)
                answer[idx++] = map[i][j];
        return answer;
    }
}