import java.util.*;

class Solution {
    public boolean[] v;
    class Node{
        public String word;
        public int cnt;
        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int Same_length(String a, String b){
        int cnt = 0;
        for(int i=0;i<a.length();i++)
            if(a.charAt(i) != b.charAt(i)) cnt++;
        return cnt;
    }
    
    public int BFS(String[] words, String begin, String target){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.word.equals(target)) return node.cnt;
            
            for(int i=0;i<words.length;i++){
                if(!v[i] && Same_length(node.word, words[i]) == 1){
                    q.add(new Node(words[i], node.cnt+1));
                    v[i] = true;
                }
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];
        return BFS(words, begin, target);
    }
}