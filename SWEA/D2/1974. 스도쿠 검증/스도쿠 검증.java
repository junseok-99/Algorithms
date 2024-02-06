import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map = new int[9][9];
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int tc = 1; tc <= T; tc++) {
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //모든 검증이 되면
            if (validBlock() && validCol() && validRow()) {
                sb.append("#" + tc + " " + "1\n");
            } else {
                sb.append("#" + tc + " " + "0\n");
            }
        }
        System.out.println(sb);
    }

    //블록 검증
    public static boolean validBlock() {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set.clear();
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j+3; c++) {
                        set.add(map[r][c]);
                    }
                }
                if (set.size() != 9) {
                    return false;
                }
            }
        }
        return true;
    }

    //열 검증
    public static boolean validCol() {
        for (int r = 0; r < 9; r++) {
            set.clear();
            for (int c = 0; c < 9; c++) {
                set.add(map[r][c]);
            }
            if (set.size() != 9) {
                return false;
            }
        }
        return true;
    }

    //행 검증
    public static boolean validRow() {
        for (int c = 0; c < 9; c++) {
            set.clear();
            for (int r = 0; r < 9; r++) {
                set.add(map[r][c]);
            }
            if (set.size() != 9) {
                return false;
            }
        }
        return true;
    }
}