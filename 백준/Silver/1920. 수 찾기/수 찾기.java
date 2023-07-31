import java.io.*;
import java.util.*;

public class Main{
    
    public static int search(List<Integer> refer, int num){
        int left = 0, right = refer.size()-1;

        while(left <= right){
            int mid = (left+right) / 2;
            if(refer.get(mid) > num) right = mid-1;
            else if(refer.get(mid) < num) left = mid+1;
            else return 1;
        }
        return 0;
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
            bw.write(search(A,B.get(i))+"\n");

        bw.flush();
        bw.close();

    }
}