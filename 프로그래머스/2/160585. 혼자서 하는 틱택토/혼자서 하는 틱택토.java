class Solution {
    private boolean isEarly = false;
    private boolean isLater = false;
    private int earlyAttack = 0;
    private int laterAttack = 0;
    private int answer=1;
    private char[][] map = new char[3][3];
    
    public void changeWinner(char c) {
        if(c == 'O') {
            isEarly = true;
        } else if(c=='X') {
            isLater = true;
        }
    }
    
    public void checkGameVictory() {
        int[] dx = {1,1,1,0,2};
        int[] dy = {0,1,2,1,1};
        for(int i=0;i<5;i++) {
            char c = map[dy[i]][dx[i]];
            if(c == '.' || (isEarly & isLater)) continue;
            
            if(dy[i] + dx[i] == 2) { //대각선
                if(map[dy[i]-1][dx[i]-1] == c && map[dy[i]+1][dx[i]+1] == c) {
                    changeWinner(c);
                }    
                if(map[dy[i]-1][dx[i]+1] == c && map[dy[i]+1][dx[i]-1] == c) {
                    changeWinner(c);
                } 
            }
            if(dx[i] == 1) { //가로 중앙
                if(map[dy[i]][dx[i]-1] == c && map[dy[i]][dx[i]+1] == c) {
                    changeWinner(c);
                }  
            }
            if(dy[i] == 1) { //세로 중앙
                if(map[dy[i]-1][dx[i]] == c && map[dy[i]+1][dx[i]] == c) {
                    changeWinner(c);
                }  
            }
        }
    }
    
    public void checkAttackCount() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                char c = map[i][j];
                if(c == 'O') {
                    earlyAttack++;
                } else if(c == 'X') {
                    laterAttack++;
                }
            }
        }
    }
    
    public void checkSequence() {
        if(isEarly & isLater) {
            answer = 0;
        } else if(isEarly | isLater) {
            if(isEarly && (earlyAttack - laterAttack) != 1 ) {
                answer = 0;
            } else if(isLater && earlyAttack != laterAttack) {
                answer = 0;
            }
        } else if((earlyAttack - laterAttack) != 1 && (earlyAttack - laterAttack) != 0) {
            answer = 0;
        }
    }
    
    public int solution(String[] board) {
        
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        checkGameVictory();
        checkAttackCount();
        checkSequence();
        
        return answer;
    }
}