import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static MapInfo[][] map;
    static MapInfo[][] tmpMap;
    static int[][] delta = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int N;
    static int K;
    static Deque<Point> pointQue = new ArrayDeque<>();
    static Deque<Point> mustCombinePointQue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new MapInfo[N][N];
        tmpMap = new MapInfo[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                map[i][j] = new MapInfo();
                tmpMap[i][j] = new MapInfo();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pointQue.add(new Point(y, x));
            map[y][x].add(new Fireball(m, s, d));
        }

        calcMovedFireball();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += map[i][j].massSum;
            }
        }
        System.out.println(answer);
    }

    public static void calcMovedFireball() {
        int[][] ballCounts;

        while (K > 0) {
            ballCounts = new int[N][N];
            int pointQueSize = pointQue.size();

            //현재 파이어볼 움직이기
            while (pointQueSize > 0) {
                Point p = pointQue.poll();

                int mapSize = map[p.y][p.x].size();
                for (int i = 0; i < mapSize; i++) {
                    Fireball fireball = map[p.y][p.x].poll();
                    move(ballCounts, fireball, p.y, p.x);
                }
                pointQueSize--;
            }

            //2개 이상인 파이어볼 합치기
            while (!mustCombinePointQue.isEmpty()) {
                Point p = mustCombinePointQue.poll();
                if (tmpMap[p.y][p.x].massSum < 5) {
                    tmpMap[p.y][p.x].clear();
                    continue;
                }
                tmpMap[p.y][p.x].combine();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    while (!tmpMap[i][j].isEmpty()) {
                        map[i][j].add(tmpMap[i][j].poll());
                    }
                }
            }

            K--;
        }
    }

    public static void move(int[][] ballCounts, Fireball fireball, int y, int x) {
        int dir = fireball.dir;
        int speed = fireball.speed;
        int ty = (N + y + delta[dir][0] * (speed % N)) % N;
        int tx = (N + x + delta[dir][1] * (speed % N)) % N;

        ballCounts[ty][tx]++;
        if (ballCounts[ty][tx] == 2) {
            mustCombinePointQue.add(new Point(ty, tx));
        }  else if (ballCounts[ty][tx] == 1){
            pointQue.add(new Point(ty, tx));
        }
        tmpMap[ty][tx].add(fireball);
    }

    //합쳐진 파이어볼의 질량 계산
    public static int calcMass(int massSum) {
        return (int) Math.floor(massSum / 5.0);
    }

    //합쳐진 파이어볼의 속력 계산
    public static int calcSpeed(int vSum, int fireBallCnt) {
        return (int) Math.floor(vSum / (double) fireBallCnt);
    }
}

class MapInfo {
    Deque<Fireball> balls = new ArrayDeque<>();
    int massSum;
    int speedSum;
    int oddDir;
    int evenDir;

    public void add(Fireball fireball) {
        balls.add(fireball);
        massSum += fireball.mass;
        speedSum += fireball.speed;
        if (fireball.dir % 2 == 0) {
            evenDir++;
        } else {
            oddDir++;
        }
    }

    public Fireball poll() {
        Fireball fireball = balls.poll();
        massSum -= fireball.mass;
        speedSum -= fireball.speed;
        if (fireball.dir % 2 == 0) {
            evenDir--;
        } else {
            oddDir--;
        }
        return fireball;
    }

    public int size() {
        return balls.size();
    }

    public boolean isEmpty() {
        return balls.isEmpty();
    }

    public void clear() {
        balls.clear();
        massSum = 0;
        speedSum = 0;
        oddDir = 0;
        evenDir = 0;
    }

    public void combine() {
        int size = size();
        int mass = (int) Math.floor(massSum / 5.0);
        int speed = (int) Math.floor(speedSum / (double) size);
        int[] dirs1 = {0, 2, 4, 6};
        int[] dirs2 = {1, 3, 5, 7};

        if (oddDir == 0 || evenDir == 0) {
            clear();
            for (int i = 0; i < 4; i++) {
                add(new Fireball(mass, speed, dirs1[i]));
            }
        } else {
            clear();
            for (int i = 0; i < 4; i++) {
                add(new Fireball(mass, speed, dirs2[i]));
            }
        }
    }

    public int getMassSum() {
        return massSum;
    }
}

class Fireball {
    int mass;
    int speed;
    int dir;

    public Fireball(int mass, int speed, int dir) {
        this.mass = mass;
        this.speed = speed;
        this.dir = dir;
    }

    public String toString() {
        return "[" + mass + ", " + speed + ", " + dir + "]";
    }
}

class Point {
    int x;
    int y;
    public Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}