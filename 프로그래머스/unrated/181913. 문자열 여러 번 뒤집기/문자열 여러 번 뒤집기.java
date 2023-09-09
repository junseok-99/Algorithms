class Solution {
    public String solution(String my_string, int[][] queries) {
        
        char[] arr = my_string.toCharArray();
        
        for(int[] query: queries) {
            int len = query[1] - query[0];
            
            for(int i=0;i<=len / 2;i++) {
                char tmp = arr[query[0] + i];
                arr[query[0] + i] = arr[query[1] - i];
                arr[query[1] - i] = tmp;
            }
        }
        
        return new String(arr);
    }
}