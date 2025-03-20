import java.io.*;
import java.util.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Set<Integer> multiTab = new HashSet<>();
		int[] seq = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		int answer = 0;
		while (idx < K) {
			if (multiTab.contains(seq[idx]) || multiTab.size() < N) {
				multiTab.add(seq[idx]);
			} else {
				PriorityQueue<Info> pq = new PriorityQueue<>();
				for (int type : multiTab) {
					int tmp = K;
					for (int i = idx + 1; i < K; i++) {
						if (seq[i] == type) {
							tmp = Math.min(tmp, i);
						}
					}				
//					System.out.println(type + " | " + tmp);
					pq.add(new Info(type, tmp));
				}
				int type = pq.poll().type;
				multiTab.remove(type);
//				System.out.println(type);
				++answer;
				multiTab.add(seq[idx]);
			}
			idx++;
		}
		System.out.println(answer);
	}
}

class Info implements Comparable<Info> {
	int type;
	int seq;
	
	public Info(int type, int seq) {
		this.type = type;
		this.seq = seq;
	}
	
	public int compareTo(Info io) {
		return Integer.compare(io.seq, this.seq);
	}
}