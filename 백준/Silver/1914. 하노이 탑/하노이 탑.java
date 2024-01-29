import java.io.*;
import java.math.BigInteger;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2");
        count = count.pow(N);
        count = count.subtract(new BigInteger("1"));
        sb.append(count.toString() + "\n");

        if (N <= 20) {
            //3개를 C로 옮긴다
            hanoi(N, 1, 2, 3);
        }
        System.out.println(sb.toString());
    }

    public static void hanoi(int num, int fromA, int midB, int toC) {

        if (num == 1) {
            sb.append(fromA + " " + toC + "\n");
            return;
        }

        //제일 큰 거를 C로 옮기기 위해서는 그 위 n - 1개가 B로 와야함
        //아래 재귀 문에서 n - 1개가 B, C를 왔다갔다 하면서 결국엔 B로옴
        hanoi(num - 1, fromA, toC, midB);

        //n - 1개가 B에 있기 때문에 제일 큰거를 C로 옮김
        sb.append(fromA + " " + toC + "\n");

        //B에 있는 n - 1개가 C로 와야함
        //아래 재귀 문에서 n - 1개가 A, B를 왔다갔다 하면서 결국엔 C로옴
        hanoi(num - 1, midB, fromA, toC);
    }
}