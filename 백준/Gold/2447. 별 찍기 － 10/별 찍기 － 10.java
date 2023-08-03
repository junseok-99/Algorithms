import java.io.*;
import java.util.*;

public class Main{

    public static void fills(char[][] star,int n, int y, int x){
        int mid = n / 3;
        if(n==3){
            for(int i=y;i<y+n;i++) {
                for (int j = x; j < x + n; j++){
                    if (i == y + 1 && j == x + 1) continue;
                    star[i][j] = '*';
                }
            }
            return;
        }

        for(int i=y;i<y+n;i+=mid)
            for(int j=x;j<x+n;j+=mid) {
                if(i==y+mid && j==x+mid) continue;
                fills(star, mid, i, j);
            }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        char[][] star = new char[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(star[i], ' ');

        fills(star,n,0,0);

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                bw.write(star[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}