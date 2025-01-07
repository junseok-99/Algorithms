import java.util.*;

/*
    1 2 3 4 5 6
    1
    2 = 1 + 1 
    3 = 1 + 2 , 2 + 1
    4 = 1 + 3, 2 + 2, 3 + 1
*/
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        int tmp = N;
        int cnt = 1;
        
        if (N == number) return 1;
        
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for (int step = 2; step <= 8; step++) {
            int n1 = 1;
            tmp = tmp * 10 + N;
            list.get(step).add(tmp);
            
            if (tmp == number) return step;
            
            while (n1 < step) {
                int n2 = step - n1;

                for (int num1 : list.get(n1)) {
                    for (int num2 : list.get(n2)) {
                        int[] rets = new int[4];
                        rets[0] = num1 + num2;
                        rets[1] = num1 - num2;
                        rets[2] = num1 * num2;
                        rets[3] = -1;
                        
                        if (num2 != 0) rets[3] = num1 / num2;
                        
                        list.get(step).add(rets[0]);
                        list.get(step).add(rets[1]);
                        list.get(step).add(rets[2]);
                        list.get(step).add(rets[3]);
                        
                        for (int i = 0; i < 4; i++) {
                            if (rets[i] == number) return step;
                        }
                    }
                }
                ++n1;
            }
        }
        return -1;
    }
}