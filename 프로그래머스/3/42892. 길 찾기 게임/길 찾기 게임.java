import java.util.*;

class Solution {
    
    int maxN;
    int maxY;
    List<Tree> list;
    int depth;
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        maxY = -1;
        list = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Tree(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
            
            if (maxY < nodeinfo[i][1]) {
                maxY = nodeinfo[i][1];
                maxN = i + 1;
            }
        }
        // System.out.println(list);
        // System.out.println(maxN);
        
        Collections.sort(list, (o1, o2) -> o2.y == o1.y ? o1.x - o2.x : o2.y - o1.y);
        maxN = 1;
        
        for (int i = 1; i < nodeinfo.length; i++) {
            Tree tree = list.get(i);
            addNodes(tree);
        }
        
        preSearch(list.get(maxN - 1), answer);
        depth = 0;
        subSearch(list.get(maxN - 1), answer);
        
        return answer;
    }
    
    public void preSearch(Tree tree, int[][] answer) {
        if (tree == null) return;
        answer[0][depth++] = tree.n;
        preSearch(tree.left, answer);
        preSearch(tree.right, answer);
    }
    
    public void subSearch(Tree tree, int[][] answer) {
        if (tree == null) return;
        subSearch(tree.left, answer);
        subSearch(tree.right, answer);
        answer[1][depth++] = tree.n;
    }
    
    public void addNodes(Tree tree) {        
        list.get(maxN - 1).addNode(tree);
    }
}

class Tree {
    int n;
    int x;
    int y;
    Tree left;
    Tree right;
    
    public Tree(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }
    
    public void addNode(Tree tree) {
        if (this.x < tree.x) {
            if (this.right == null) this.right = tree;
            else {
                if (this.right.y > tree.y) this.right.addNode(tree);
                else {
                    Tree tmp = this.right;
                    this.right = tree;
                    tree.addNode(tmp);
                }
            }
        } else if (this.x > tree.x) {
            if (this.left == null) this.left = tree;
            else {
                if (this.left.y > tree.y) this.left.addNode(tree);
                else {
                    Tree tmp = this.left;
                    this.left = tree;
                    tree.addNode(tmp);
                }
            }
        }
    }
    
    public String toString() {
        return this.n + " " + this.x + " " + this.y;
    }
}