import java.util.*;

class Solution {
    
    int N;
    int M;
    int[][] map;
    boolean[][] visitedMap;
    boolean[] visited;
    Map<Integer, Integer> oilMap;
    int cnt;
    int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        map = new int[N][M];
        visitedMap = new boolean[N][M];
        oilMap = new HashMap<>();
        cnt = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visitedMap[i][j] && land[i][j] == 1) {
                    bfs(i, j, land);
                    ++cnt;
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            visited = new boolean[cnt];
            visited[0] = true;
            int sum = 0;
            
            for (int j = 0; j < N; j++) {
                if (visited[map[j][i]]) continue;
                visited[map[j][i]] = true;
                sum += oilMap.get(map[j][i]);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    public void bfs(int r, int c, int[][] land) {
        Deque<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c));
        visitedMap[r][c] = true;
        int oilCnt = 0;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.r][p.c] = cnt;
            
            for (int i = 0; i < 4; i++) {
                int tr = p.r + d[i][0];
                int tc = p.c + d[i][1];
                
                if (invalidRange(tr, tc) || visitedMap[tr][tc] || land[tr][tc] != 1) continue;
                q.add(new Point(tr, tc));
                visitedMap[tr][tc] = true;
            }
            oilCnt++;
        }
        oilMap.put(cnt, oilCnt);
    }
    
    public boolean invalidRange(int tr, int tc) {
        return tr < 0 || tr >= N || tc < 0 || tc >= M;
    }
}

class Point {
    int r;
    int c;
    
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}