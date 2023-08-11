import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        
        List<Integer> ret = new ArrayList<>();
        List<List<Integer>> stu = new ArrayList<>();
        
        stu.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
        stu.add(new ArrayList<>(Arrays.asList(2,1,2,3,2,4,2,5)));
        stu.add(new ArrayList<>(Arrays.asList(3,3,1,1,2,2,4,4,5,5)));
        
        int max = -1;
        int[] math_givers = new int[3];
        int[] sizes = {stu.get(0).size(), stu.get(1).size(), stu.get(2).size()};
        
        for(int i=0;i<answers.length;i++){
            if(stu.get(0).get(i%sizes[0]) == answers[i]) math_givers[0]++;
            if(stu.get(1).get(i%sizes[1]) == answers[i]) math_givers[1]++;
            if(stu.get(2).get(i%sizes[2]) == answers[i]) math_givers[2]++;
            max = Math.max(Math.max(math_givers[0],math_givers[1]), math_givers[2]);
        }
        for(int i=0;i<3;i++)
            if(max == math_givers[i]) ret.add(i+1);
        
        return ret;
    }
}