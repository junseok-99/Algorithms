import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int answer;
    static int[][] map;
    static boolean[] isSelected;
    static int N;
    static List<Point> persons; //사람들의 좌표들
    static Floor[] floors; //계단의 정보들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = Integer.MAX_VALUE;
            persons = new ArrayList<>();
            floors = new Floor[2];

            //지도, 사람, 계단 초기화
            int floorIdx = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) persons.add(new Point(j, i));
                    else if (map[i][j] > 1) floors[floorIdx++] = new Floor(j, i, map[i][j]);
                }
            }

            //부분집합을 만들어서 계단 내려보냄
            isSelected = new boolean[persons.size()];
            subSet(0);

            sb.append("#").append(tc).append(' ').append(answer).append("\n");
        }

        System.out.println(sb);
    }

    //사람들이 계단으로 가는 부분 집합 생성
    public static void subSet(int depth) {
        if (depth == persons.size()) {
            PriorityQueue<Person> pq = new PriorityQueue<>();

            //사람 추가
            for (int i = 0; i < persons.size(); i++) {
                Point p = persons.get(i);
                int floorNum = !isSelected[i] ? 0 : 1;
                int time = floors[floorNum].getTime(p);
                pq.add(new Person(p, floorNum, time));
            }

            //사람들 계단 내리기
            int movedTime = downFloor(pq);
            answer = Math.min(answer, movedTime);
            return;
        }

        isSelected[depth] = true;
        subSet(depth + 1);
        isSelected[depth] = false;
        subSet(depth + 1);
    }


    //계단 내려가기
    public static int downFloor(PriorityQueue<Person> pq) {
        int curPerson = persons.size();
        int time = 1;
        for (int i = 0; i < 2; i++) {
            floors[i].clear();
        }
        while (true) {
            for (int i = 0; i < 2; i++) {
                curPerson -= floors[i].completedDown(time);
            }

            //사람이 계단으로 이동했으면
            while (!pq.isEmpty() && pq.peek().time == time) {
                Person person = pq.poll();
                int floorNum = person.floorNum;
                //계단 입구에 사람 추가
                floors[floorNum].addPerson(person, time);
            }


//            System.out.println("Time = " + curPerson);
            //계단에 있는 대기자 입구로 이동
//            for (int i = 0; i < 2; i++) {
//                floors[i].addWaitPerson();
//            }
            //System.out.println(curPerson);
            if (curPerson == 0) break;
            time++;
        }
//        System.out.println("FINAL TIME = " + time);
        return time;
    }
}

class Floor {
    Point p;
    int downTime;
    Deque<Person> inQ;
    Deque<Person> waitQ;

    Floor(int x, int y, int downTime) {
        this.p = new Point(x, y);
        this.downTime = downTime;
        inQ = new ArrayDeque<>();
        waitQ = new ArrayDeque<>();
    }

    public void clear() {
        inQ.clear();
        waitQ.clear();
    }

    //계단을 내려간 사람의 수
    public int completedDown(int curTime) {
        int cnt = 0;

        while (!inQ.isEmpty() && inQ.peek().time == curTime) {
            cnt++;
            inQ.poll();
        }
        addWaitPerson(curTime);
        return cnt;
    }

    //계단에 사람 추가
    public void addPerson(Person person, int curTime) {
        person.setTime(downTime + curTime + 1);
        if (inQ.size() == 3) {
            person.setTime(curTime + 1);
            waitQ.add(person);
        }
        else if (inQ.size() < 3)
            inQ.add(person);

    }

    //대기자 입구로 이동
    public void addWaitPerson(int curTime) {
        while (!waitQ.isEmpty() && inQ.size() < 3) {
            Person person = waitQ.poll();
            person.setTime(curTime + downTime);
            inQ.add(person);
        }
    }

    public int getTime(Point p) {
        return Math.abs(this.p.x - p.x) + Math.abs(this.p.y - p.y);
    }
}

class Person implements Comparable<Person>{
    Point p;
    int floorNum;
    int time;

    Person(Point p, int floorNum, int time) {
        this.p = p;
        this.floorNum = floorNum;
        this.time = time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String toString() {
        return time + ", ";
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.time, o.time);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}