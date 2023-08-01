import java.util.*;
import java.io.*;
public class Main {

    public static int mapModify(int[][] map, int n, int hei){
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] <= hei)
                    visited[i][j] = true;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    dfs(i,j,n,map, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void dfs(int y, int x, int n, int[][] m, boolean[][] v){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        v[y][x] = true;

        for(int i=0;i<4;i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(0 <= tx && tx < n && 0 <= ty && ty < n && !v[ty][tx])
                dfs(ty,tx,n,m,v);
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        int hei = 0, max_hei = -1, max_safe = -1;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max_hei < map[i][j])
                    max_hei = map[i][j];
            }
        }

        for(;hei <= max_hei;hei++){
            max_safe = Math.max(max_safe, mapModify(map,n,hei));
        }

        System.out.println(max_safe);

    }

}
