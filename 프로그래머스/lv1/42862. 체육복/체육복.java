import java.util.Arrays;

class Solution {
    public int check(int[] arr){
        int num = 0;
        for(int i: arr) if(i>0) num++;
        return num;
    }
    
    public int test(int n, int[] lost, int[] reserve){
        int[] stu = new int[n];
        Arrays.fill(stu,1);
        
        for(int i: lost) stu[i-1]--;
        for(int i: reserve) stu[i-1]++;
        
        Arrays.sort(lost);
        for(int i: lost){
            if(stu[i-1] < 1){
                if(i-2 > -1 && stu[i-2] > 1){
                    stu[i-2]--;
                    stu[i-1]++;
                }
                else if(i < n && stu[i] > 1){
                    stu[i]--;
                    stu[i-1]++;
                }
            }
        }
        return check(stu);
    }
    
    public int solution(int n, int[] lost, int[] reserve) {
        int[] a = {3,5};
        int[] b = {4,2};
        
        System.out.println(test(5,b,a));
        return test(n,lost,reserve);
    }
}