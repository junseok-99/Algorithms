class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alpha = new int[26];
        System.out.println((int)('Z'));
        for(int i=0;i<keymap.length;i++) {
            for(int j=0;j<keymap[i].length();j++) {
                char c = keymap[i].charAt(j);
                if(alpha[(int)c - 65] == 0) {
                    alpha[(int)c - 65] = j+1;
                } else {
                    alpha[(int)c - 65] = Math.min(alpha[(int)c - 65], j+1);
                }
            }
        }
        
        for(int i=0;i<targets.length;i++) {
            int sum = 0;
            for(int j=0;j<targets[i].length();j++) {
                int n = (int)targets[i].charAt(j) - 65;
                sum += alpha[n];
                if(alpha[n] == 0) {
                    sum = -1;
                    break;
                }
            }
            
            answer[i] = sum;
            
        }
        return answer;
    }
}