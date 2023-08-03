import java.io.*;
import java.util.*;

public class Main{

    public static int Lower(List<Integer> re, int num){
        int left = 0, right = re.size();

        while(left < right){
            int mid = (left+right) / 2;
            if(re.get(mid) >= num) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public static int Upper(List<Integer> re, int num){
        int left = 0, right = re.size();

        while(left < right){
            int mid = (left+right) / 2;
            if(re.get(mid) > num) right = mid;
            else left = mid+1;
        }
        return left;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            A.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++)
            B.add(Integer.parseInt(st.nextToken()));

        Collections.sort(A);

        for(int i=0;i<m;i++)
            bw.write(Upper(A,B.get(i))-Lower(A,B.get(i))+"\n");

        bw.flush();
        bw.close();

    }
}