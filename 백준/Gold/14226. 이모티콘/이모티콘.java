import java.io.*;
import java.util.*;

class Main {
	
	static int S;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[S + 1][S + 1];
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Deque<Emoticon> q = new ArrayDeque<>();
		q.add(new Emoticon(1, 0));
		int time = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Emoticon emo = q.poll();
				
				if (emo.cnt == S) return time;
				if (visited[emo.cnt][emo.board]) continue;
				
				if (emo.cnt < S) {
					q.add(new Emoticon(emo.cnt, emo.cnt));
				} 
				if (emo.board > 0 && emo.cnt + emo.board <= S) {
					q.add(new Emoticon(emo.cnt + emo.board, emo.board));
				} 
				if (emo.cnt - 1 > 0) q.add(new Emoticon(emo.cnt - 1, emo.board));
				
				visited[emo.cnt][emo.board] = true; 
			}
			++time;
		}
		return -1;
	}
}

class Emoticon {
	int cnt;
	int board;
	
	public Emoticon(int cnt, int board) {
		this.cnt = cnt;
		this.board = board;
	}
}