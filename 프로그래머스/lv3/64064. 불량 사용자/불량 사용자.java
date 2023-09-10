import java.util.*;

class Solution {
    int userSize;
    List<String> li = new ArrayList<>();
    Set<String> set = new HashSet<>();
    boolean[] visited;
    
    public void dfs(int depth, String[] user_id, String s) {
        if (depth == userSize) {
            li.add(s);
        }
        for(int i=0;i<userSize;i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, user_id, s + user_id[i] + " ");
                visited[i] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int bannedSize = banned_id.length;
        userSize = user_id.length;
        visited = new boolean[userSize];
        
        dfs(0, user_id, "");
        
        for(int i=0;i<li.size();i++) {
            String[] tmp = li.get(i).split(" ");
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<=userSize;j++) {
                if (cnt == bannedSize) {
                    sb.deleteCharAt(sb.length() - 1);
                    String s = makeId(sb.toString().split(" "));
                    if (!set.contains(s)) {
                        ++answer;
                        set.add(s);
                    }
                    break;
                }
                if (j < userSize && checkId(tmp[j], banned_id[cnt])) {
                    ++cnt;
                    sb.append(tmp[j] + " ");
                }
            }
        }
        return answer;
    }
    
    public String makeId(String[] arr) {
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    
    public boolean checkId(String s1, String s2) {
        if (s1.length() == s2.length()) {
            for(int i=0;i<s1.length();i++) {
                if (s2.charAt(i) == '*') {
                    continue;
                } else if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}