import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;
    static int n;
    static StarPos[] stars;
    static List<Star> starList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        stars = new StarPos[n];
        starList = new ArrayList<>();

        //별들의 좌표 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new StarPos(x, y);
        }

        //가중치 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double weight = getTwoPointDist(stars[i], stars[j]);
                starList.add(new Star(i, j, weight));
            }
        }

        makeSet();
        Collections.sort(starList);

        int cnt = 0;
        double answer = 0;
        for (Star star : starList) {
            if (union(star.source, star.dest)) {
                ++cnt;
                answer += star.weight;
            }
            if (cnt == n) break;
        }
        System.out.printf("%.2f", answer);
    }

    //집합 생성
    public static void makeSet() {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return false;
        if (parentA < parentB) {
            parents[parentB] = parents[parentA];
        } else if (parentA > parentB) {
            parents[parentA] = parents[parentB];
        }
        return true;
    }

    public static int find(int starNum) {
        if (parents[starNum] == starNum) {
            return starNum;
        }
        return parents[starNum] = find(parents[starNum]);
    }

    public static double getTwoPointDist(StarPos a, StarPos b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}

class StarPos {
    double x;
    double y;

    public StarPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Star implements Comparable<Star> {
    int source;
    int dest;
    double weight;

    public Star(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public String toString() {
        return source + ", " + dest + ", " + weight;
    }

    @Override
    public int compareTo(Star o) {
        return Double.compare(this.weight, o.weight);
    }
}