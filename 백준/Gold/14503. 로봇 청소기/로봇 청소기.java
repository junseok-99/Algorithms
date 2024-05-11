import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static Robot robot = new Robot();
    static int[][] map;
    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //Init Robot
        st = new StringTokenizer(br.readLine());
        robot.r = Integer.parseInt(st.nextToken());
        robot.c = Integer.parseInt(st.nextToken());
        robot.d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            int r = robot.r;
            int c = robot.c;

            //1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (map[r][c] == 0) {
                map[r][c] = -1;
                ++answer;
            }

            //주변 4칸 청소여부 확인
            boolean isClean = true;
            for (int i = 0; i < 4; i++) {
                int tr = r + delta[i][0];
                int tc = c + delta[i][1];
                if (invalidBlank(tr, tc)) continue;
                if (map[tr][tc] == 0){
                    isClean = false;
                    break;
                }
            }

            //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (isClean) {
                int tr = r + delta[robot.d][0] * -1;
                int tc = c + delta[robot.d][1] * -1;

                //2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (invalidBlank(tr, tc)) break;

                //2.1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                robot.r = tr;
                robot.c = tc;
            }
            //3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            else {
                for (int i = 0; i < 4; i++) {
                    //3-1. 반시계 방향으로 90도 회전한다.
                    robot.spin();

                    int tr = r + delta[robot.d][0];
                    int tc = c + delta[robot.d][1];
                    //3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                    if (!invalidBlank(tr, tc) && map[tr][tc] == 0) {
                        robot.r = tr;
                        robot.c = tc;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean invalidBlank(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 1;
    }
}

class Robot {
    int r;
    int c;
    int d;

    public Robot() {
    }
    public Robot(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }

    public void spin() {
        this.d = (this.d + 3) % 4;
    }
}