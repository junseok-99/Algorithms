class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer;

        int[][] tmp = {{-1,-1}, {-1,-1}};
        int mi=51, mx=-1;

        for(int i=0;i<wallpaper.length;i++){
            int cnt = 0;
            for(char j: wallpaper[i].toCharArray()){
                if(j == '#'){
                    if(tmp[0][0] == -1){
                        tmp[0][0] = i;
                        tmp[0][1] = cnt;
                        tmp[1][0] = i+1;
                        tmp[1][1] = cnt+1;
                        mi = cnt;
                        mx = cnt;
                    }
                    else if(cnt < mi){
                        tmp[0][1] = cnt;
                        mi = cnt;
                    }
                    else if(cnt > mx){
                        tmp[1][0] = i+1;
                        tmp[1][1] = cnt+1;
                        mx = cnt;
                    }
                    tmp[1][0] = i+1;
                }

                cnt++;

            }
        }
        

        answer = new int[4];

        answer[0] = tmp[0][0];
        answer[1] = tmp[0][1];
        answer[2] = tmp[1][0];
        answer[3] = tmp[1][1];

        return answer;
    }
}