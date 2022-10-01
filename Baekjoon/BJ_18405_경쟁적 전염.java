import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus implements Comparable<Virus> {
	
	private int x, y, idx, time;
	
	public Virus(int x, int y, int idx, int time) {
		this.x = x;
		this.y = y;
		this.idx = idx;
		this.time = time;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getIdx() {
		return idx;
	}
	public int getTime() {
		return time;
	}
	
	// 바이러스 번호(idx) 기준으로 낮은 순서로 정렬
		@Override
		public int compareTo(Virus o) {
			if(this.idx < o.idx) {
				return -1;
			}
			return 1;
		}
}

public class Main {
	
	static int N, K, S;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
                ArrayList<Virus> viruses = new ArrayList<Virus>();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] != 0) {
					viruses.add(new Virus(i, j, map[i][j], 0));
				}
			}
		}
		// 바이러스 낮은 번호로 정렬 후, 큐에 넣기
		Collections.sort(viruses);
		Queue<Virus> q = new LinkedList<Virus>();
		
		for(int i = 0; i < viruses.size(); i++) {
			q.offer(viruses.get(i));
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());	// S초 뒤
		int X = Integer.parseInt(st.nextToken())-1;	// map[x-1][y-1]에 존재하는 바이러스의 종류 출력
		int Y = Integer.parseInt(st.nextToken())-1;
	
		// bfs
                while(!q.isEmpty()) {
			Virus v = q.poll();		// 큐에서 노드 하나 꺼내기
			
			if (v.getTime() == S) break;
			
			int nowX = v.getX();
			int nowY = v.getY();
			
			//해당 노드의 인접노드 중에서 방문하지 않은 ‘모든 노드’를 큐에 삽입하고 방문처리
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
					continue;
				
				if(map[nextX][nextY] == 0) {
					map[nextX][nextY] = v.getIdx();
					q.add(new Virus(nextX, nextY, v.getIdx(), v.getTime() + 1));
				}
			}
		}
		
		System.out.println(map[X][Y]);
	}

}
