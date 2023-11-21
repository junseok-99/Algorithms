class Solution {
    public boolean ck(char c, int[][] map, int posy, int posx, int dist){
        if(c == 'E'){
            int tmp = posx + dist;
            for(;posx <= tmp;posx++){
                if(map[posy][posx] == -1) return true;
            }
        }
        else if(c == 'W'){
            int tmp = posx - dist;
            for(;posx >= tmp;posx--){
                if(map[posy][posx] == -1) return true;
            }
        }
        else if(c == 'N'){
            int tmp = posy - dist;
            for(;posy >= tmp;posy--){
                if(map[posy][posx] == -1) return true;
            }
        }
        else{
            int tmp = posy + dist;
            for(;posy <= tmp;posy++){
                if(map[posy][posx] == -1) return true;
            }
        }
        return false;
    }
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[][] map = new int[park.length][park[0].length()];
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j) == 'O') map[i][j] = 1;
                else if(park[i].charAt(j) == 'X') map[i][j] = -1;
                else{
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for(String s: routes){
            String[] tmp = s.split(" ");
            int dist = Integer.parseInt(tmp[1]);
            if(tmp[0].equals("E")){
                if(map[0].length <= answer[1] + dist) continue;
                else if(ck('E',map,answer[0],answer[1],dist)) continue;
                answer[1] += dist;
            }
            else if(tmp[0].equals("W")){
                if(0 > answer[1] - dist) continue;
                else if(ck('W',map,answer[0],answer[1],dist)) continue;
                answer[1] -= dist;
            }
            else if(tmp[0].equals("N")){
                if(0 > answer[0] - dist) continue;
                else if(ck('N',map,answer[0],answer[1],dist)) continue;
                answer[0] -= dist;
            }
            else{
                if(map.length <= answer[0] + dist) continue;
                else if(ck('S',map,answer[0],answer[1],dist)) continue;
                answer[0] += dist;
            }
        }
        
        return answer;
    }
}