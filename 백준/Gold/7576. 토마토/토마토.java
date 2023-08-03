import java.io.*;
import java.util.*;

public class Main{

    public static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int[][] table;
    public static int notomato = 0;
    public static Queue<Pos> q = new LinkedList<>();
    public static int bfs(int m, int n){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<Queue> q2 = new LinkedList<>();
        q2.add(q);
        int cnt = -1;
        while(!q2.isEmpty()) {
            q2.poll();
            int size = q.size();
            for(int j=0;j<size;j++) {
                Pos p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int tx = p.x + dx[i];
                    int ty = p.y + dy[i];
                    if (tx < m && tx >= 0 && ty < n && ty >= 0) {
                        if (table[ty][tx] == 0) {
                            table[ty][tx] = 1;
                            notomato--;
                            q.add(new Pos(tx, ty));
                        }
                    }
                }
            }
            if(q.size() > 0) q2.add(q);
            cnt++;
        }
        return notomato > 0 ? -1 : cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        table = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int t = Integer.parseInt(st.nextToken());
                if(t==0) ++notomato;
                else if(t==1) q.add(new Pos(j,i));
                table[i][j] = t;
            }
        }

        if(notomato == 0){
            bw.write(notomato+"");
            bw.flush();
        }
        else{
            bw.write(bfs(m,n)+"");
            bw.flush();
        }

        bw.close();
    }
}