import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		BirthDay[] births = new BirthDay[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int dd = Integer.parseInt(st.nextToken());
			int mm = Integer.parseInt(st.nextToken());
			int yyyy = Integer.parseInt(st.nextToken());
			births[i] = new BirthDay(name, dd, mm, yyyy);
		}
		Arrays.sort(births);
		
		System.out.println(births[n - 1].name);
		System.out.println(births[0].name);
	}

}

class BirthDay implements Comparable<BirthDay> {
	String name;
	int dd;
	int mm;
	int yyyy;
	
	
	public BirthDay(String name, int dd, int mm, int yyyy) {
		this.name = name;
		this.dd = dd;
		this.mm = mm;
		this.yyyy = yyyy;
	}


	@Override
	public int compareTo(BirthDay o) {
		if (this.yyyy == o.yyyy) {
			if (this.mm == o.mm) {
				return Integer.compare(this.dd, o.dd);
			}
			return Integer.compare(this.mm, o.mm);
		}
		return Integer.compare(this.yyyy, o.yyyy);
	}
}