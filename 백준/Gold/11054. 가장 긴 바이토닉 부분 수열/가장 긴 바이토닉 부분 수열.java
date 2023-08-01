import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] ldp = new int[N];
        int[] rdp = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            ldp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && ldp[i] < ldp[j] + 1) {
                    ldp[i] = ldp[j] + 1;
                }
            }
        }

        for(int i = N-1; i > -1; i--) {
            rdp[i] = 1;
            for(int j = N-1; j > i; j--) {
                if(arr[j] < arr[i] && rdp[i] < rdp[j] + 1) {
                    rdp[i] = rdp[j] + 1;
                }
            }
        }

        for(int i=0;i<N;i++) {
            answer = Math.max(answer, ldp[i] + rdp[i] - 1);
        }

        System.out.println(answer);
    }
}