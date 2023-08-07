import java.util.*;

class Solution {
    class Info {
        int joinNum;
        int sum;
        
        Info(int joinNum, int sum) {
            this.joinNum = joinNum;
            this.sum = sum;
        }
        
    }
    
    private static List<Stack<Integer>> discountPrices = new ArrayList<>();;
    private int[] discountRates = {10, 20, 30, 40};
    private int maxDepth;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int[] answer = new int[2];
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.joinNum == o2.joinNum) {
                return o2.sum - o1.sum;
            }
            return o2.joinNum - o1.joinNum;
        });
        
        maxDepth = emoticons.length;
        
        dfs(emoticons, 0, new Stack<Integer>());
        
        int discountPricesLength = discountPrices.size();
        
        for(int i=0;i<discountPricesLength;i++) {
            
            Stack<Integer> tmp = discountPrices.get(i);
            int allSum = 0;
            int joinNum = 0;
            
            for(int j=0;j<users.length;j++) {
                
                int sum = 0;
                
                for(int k=0;k<tmp.size();k+=2) {
                    if(users[j][0] <= tmp.get(k)) {
                        sum += tmp.get(k+1);
                    }
                }
                
                if(users[j][1] <= sum) {
                    sum = 0;
                    ++joinNum;
                }
                
                allSum += sum;
            }
            
            pq.add(new Info(joinNum, allSum));
        }
        
        if(!pq.isEmpty()) {
            Info info = pq.poll();
            answer[0] = info.joinNum;
            answer[1] = info.sum;
        }
        
        return answer;
    }
    
    public void dfs(int[] emoticons, int depth, Stack<Integer> st) {
        
        if(depth == maxDepth) {
            discountPrices.add((Stack<Integer>)st.clone());
            return;
        }
        
        for(int i=0;i<4;i++) {
            int discountPrice = emoticons[depth] - 
                (int)(emoticons[depth] * discountRates[i] / (double)100);
            
            st.push(discountRates[i]);
            st.push(discountPrice);
            
            dfs(emoticons, depth+1, st);
            
            st.pop();
            st.pop();
        }
        
    }
}