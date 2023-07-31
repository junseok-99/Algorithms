import java.io.*;
import java.util.*;
public class Main {

    private static char[][] board;
    private static Map<Character, Boolean> visited = new HashMap<>();
    private static int maxBlock = 0;

    public static void dfs(int y, int x, int n, int m, int cnt){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        
        maxBlock = Math.max(maxBlock, cnt);

        for(int i=0;i<4;i++){
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(0 <= tx && tx < m && 0 <= ty && ty < n && !visited.get(board[ty][tx])) {
                visited.put(board[ty][tx], true);
                dfs(ty, tx, n, m, cnt + 1);
                visited.put(board[ty][tx], false);
            }
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for(int i=0;i<n;i++){
            String tmp = br.readLine();
            for(int j=0;j<m;j++)
                board[i][j] = tmp.charAt(j);
        }

        for(char i='A';i<='Z';i++) {
            if(board[0][0] == i)
                visited.put(i,true);
            else
                visited.put(i, false);
        }

        dfs(0,0,n,m, 1);

        System.out.println(maxBlock);
    }
}
