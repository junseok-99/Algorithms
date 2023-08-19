import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int answer = 0;
        
        for(String t_skill: skill_trees) {
            boolean flag = true;
            int start = 0;
            for(int i=0;i<t_skill.length();i++) {
                if (skill.contains(t_skill.substring(i, i+1))) {
                    if (skill.charAt(start) == t_skill.charAt(i)) {
                        ++start;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                ++answer;
            }
        }
        return answer;
    }
}