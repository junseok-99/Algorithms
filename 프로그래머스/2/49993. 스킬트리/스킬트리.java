import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Deque<Character> skillQ = new ArrayDeque<>();
        for (char c : skill.toCharArray()) {
            skillQ.add(c);
        }
        
        for (String s : skill_trees) {
            int len = skill.length();
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (skillQ.isEmpty()) break;
                if (skill.contains(c + "")) {
                    if (skillQ.peek() == c) {
                        skillQ.poll();
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ++answer;
            
            skillQ.clear();
            for (char c : skill.toCharArray()) {
                skillQ.add(c);
            }
        }
        return answer;
    }
}