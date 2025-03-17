import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];

		for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
				meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}

		// 시작 시간을 기준으로 오름차순, 시작 시간이 같으면 종료 시간을 기준으로 오름차순 정렬
		Arrays.sort(meetings, (a, b) -> {
				if (a[0] == b[0]) return a[1] - b[1];
				return a[0] - b[0];
		});

		// 우선순위 큐: 종료 시간이 빠른 회의가 먼저 나옴
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
				int start = meetings[i][0];
				int end = meetings[i][1];

				// 현재 회의의 시작 시간이 이전 회의의 종료 시간 이후면 같은 방 사용 가능
				if (!pq.isEmpty() && pq.peek() <= start) {
						pq.poll(); // 회의 종료된 방 재사용
				}
				pq.offer(end); // 새로운 회의 끝나는 시간 추가
		}

		System.out.println(pq.size());
	}
}