import java.io.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append(((int)Math.pow(2, N) - 1) + "\n");
        hanoi(N, 1, 2, 3);
        System.out.println(sb.toString());
    }

    public static void hanoi(int num, int fromA, int midB, int toC) {
        if (num == 1) {
            sb.append(fromA + " " + toC + "\n");
            return;
        }
        hanoi(num - 1, fromA, toC, midB);

        sb.append(fromA + " " + toC + "\n");

        hanoi(num - 1, midB, fromA, toC);
    }
}