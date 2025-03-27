class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int sucCnt = 0;
        int idx = 0;
        int hp = health;
        
        while (true) {
            ++time;
            
            if (time == attacks[idx][0]) {
                hp -= attacks[idx][1];
                if (hp <= 0) return -1;
                idx++;
                sucCnt = 0;
            } else {
                hp += bandage[1];
                sucCnt++;
                if (sucCnt == bandage[0]) {
                    sucCnt = 0;
                    hp += bandage[2];
                }
                
                if (hp >= health) hp = health;
            }
            if (idx == attacks.length) break;
        }
        return hp;
    }
}