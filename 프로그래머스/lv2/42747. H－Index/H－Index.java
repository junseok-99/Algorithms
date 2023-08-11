import java.util.Arrays;
class Solution {
    /* my_code
        int h = -1;
        int cnt1,cnt2;
        for(int i=0;i<=citations.length;i++){
            cnt1 = cnt2 = 0;
            for(int tmp: citations){
                if(i <= tmp)
                    cnt1++;
                else if(i >= tmp)
                    cnt2++;
            }
            if(cnt2 <= i && i <= cnt1)
                h = Math.max(h, i);
        }
        return h;
    */
    public int solution(int[] citations) {
        
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            max = Math.max(max,min);
        }

        return max;
    }
}