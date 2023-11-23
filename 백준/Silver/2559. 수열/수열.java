import java.io.*;

public class Main extends FastInput {

    public static void main(String[] args) throws IOException {

        initFI();
        int N = nextInt();
        int K = nextInt();
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N+1];
        int[] arr2 = new int[N+1];

        for (int i=1;i<=N;i++) {
            int n = nextInt();
            arr[i] = arr[i-1] + n;

        }
        for (int i=K;i<=N;i++) {
            arr2[i] = arr[i] - arr[i - K];
            max = Math.max(max, arr2[i]);
        }
        System.out.println(max);
    }
}
class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 20;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}