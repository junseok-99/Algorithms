import java.util.*;
import java.io.*;

public class Main{

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        for(int i=2;i<=n;i++){
            if(i%2 == 0 && i%3 == 0)
                arr[i] = Math.min(Math.min(arr[i / 2] + 1,arr[i/3] + 1),arr[i-1] + 1);
            else if(i%2 == 0)
                arr[i] = Math.min(arr[i / 2] + 1,arr[i-1] + 1);
            else if(i%3 == 0)
                arr[i] = Math.min(arr[i/3] + 1,arr[i-1] + 1);
            else
                arr[i] = arr[i-1] + 1;
        }

        bw.write(arr[n]+"");
        bw.flush();
        bw.close();
    }
}
