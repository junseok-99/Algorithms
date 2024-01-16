import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int[] arr;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt(N, M, 0, 0, "");
        bw.flush();
        bw.close();
    }
    
    public static void bt(int N, int M, int n, int depth, String str) throws IOException {
    	if (depth >= M) {
    		if (depth == M) {
    			bw.write(str + "\n");
    		}
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		bt(N, M, i + 1, depth + 1, str + arr[i] + " ");
    	}
    }
}