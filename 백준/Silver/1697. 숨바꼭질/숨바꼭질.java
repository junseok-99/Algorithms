import java.io.*;
import java.util.*;

public class Main{

    public static boolean[] v;
    public static class Pos{
        int pos;
        int cnt;
        Pos(int pos, int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    public static int bfs(int start, int end){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, 0));
        v[start] = true;
        while(!q.isEmpty()){
            Pos p = q.poll();
            if(p.pos == end) return p.cnt;

            if((p.pos-1) < 100001 && (p.pos-1) >= 0 && !v[p.pos-1]){
                q.add(new Pos(p.pos-1, p.cnt+1));
                v[p.pos-1] = true;
            }
            if((p.pos+1) < 100001 && (p.pos+1) >= 0 && !v[p.pos+1]){
                q.add(new Pos(p.pos+1, p.cnt+1));
                v[p.pos+1] = true;
            }
            if((p.pos*2) < 100001 && (p.pos*2) >= 0 && !v[p.pos*2]){
                q.add(new Pos(p.pos*2, p.cnt+1));
                v[p.pos*2] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        v = new boolean[100001];

        bw.write(bfs(n,m)+"");
        bw.flush();
        bw.close();
    }
}