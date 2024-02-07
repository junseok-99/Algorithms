import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Box> top = new ArrayList<>();
    static List<Box> bottom = new ArrayList<>();
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //벨트 위 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            top.add(new Box(false, num));
        }

        //벨트 아래 초기화
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            bottom.add(0, new Box(false, num));
        }

        moveBelt();
    }

    public static void moveBelt() {
        int zero = 0;
        int stage = 0;

        while (true) {
            //로봇내리기
            if (top.get(N - 1).isRobot) {
                top.get(N - 1).isRobot = false;
            }

            //1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            bottom.add(top.remove(N - 1));
            top.add(0, bottom.remove(0));

            //로봇내리기
            if (top.get(N - 1).isRobot) {
                top.get(N - 1).isRobot = false;
            }

            //2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            for (int i = N - 2; i >= 0; i--) {
                if (!top.get(i).isRobot) continue;
                //2-1 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
                if (top.get(i + 1).isRobot || top.get(i + 1).num < 1) continue;
                top.get(i + 1).isRobot = true;
                top.get(i + 1).num--;
                if (top.get(i + 1).num == 0) {
                    zero++;
                }
                top.get(i).isRobot = false;
            }

            //3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (!top.get(0).isRobot && top.get(0).num > 0) {
                top.get(0).isRobot = true;
                top.get(0).num--;
                if (top.get(0).num == 0) {
                    zero++;
                }
            }
            stage++;

            //4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            if (zero >= K) {
                break;
            }
        }
        System.out.println(stage);
    }
}

class Box {
    boolean isRobot;
    int num;

    public Box(boolean isRobot, int num) {
        this.isRobot = isRobot;
        this.num = num;
    }

    public String toString() {
        return "("+ isRobot + ", " + num +")";
    }
}