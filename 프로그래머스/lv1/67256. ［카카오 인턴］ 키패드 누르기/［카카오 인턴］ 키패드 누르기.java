class Solution {
    public int[][] nums = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    
    class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Pos L = new Pos(0,3);
        Pos R = new Pos(2,3);
        String main_hand = hand.equals("right") ? "R" : "L";
        
        for(int n: numbers){
            if(n==1 || n==4 || n==7){
                answer.append("L");
                L.x = nums[n][1];
                L.y = nums[n][0];
            }
            else if(n==3 || n==6 || n==9){
                answer.append("R");
                R.x = nums[n][1];
                R.y = nums[n][0];
            }
            else{
                int L_dist = Math.abs(nums[n][0] - L.y) + Math.abs(nums[n][1] - L.x);
                int R_dist = Math.abs(nums[n][0] - R.y) + Math.abs(nums[n][1] - R.x);
                if(L_dist == R_dist){
                    answer.append(main_hand);
                    if(main_hand.equals("R")){
                        R.x = nums[n][1];
                        R.y = nums[n][0];
                    }
                    else {
                        L.x = nums[n][1];
                        L.y = nums[n][0];
                    }
                }
                else if(L_dist > R_dist){
                    answer.append("R");
                    R.x = nums[n][1];
                    R.y = nums[n][0];
                }
                else{
                    answer.append("L");
                    L.x = nums[n][1];
                    L.y = nums[n][0];
                }
            }
        }
        
        return answer.toString();
    }
}