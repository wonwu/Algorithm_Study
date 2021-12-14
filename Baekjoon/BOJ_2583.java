package week10_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 영역 구하기
 * https://www.acmicpc.net/problem/2583
 * 
 * 출력)
 * 분리되어 나누어지는 영역의 개수
 * 둘째 줄에는 각 영역의 넓이를 오름차순
 * 
 * 접근법)
 * dfs
 * 행열 인덱스 주의
 * 
 */
public class BOJ_2583 {

	static int m,n;
	static int[][] map; 		    // 0 비어있음, 1 색칠된 사각형
	static PriorityQueue<Integer> pq;
	static int cnt = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1,};
	
	static void dfs(int x, int y) {
		map[x][y] = 2;
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			
			if(nX < 0 || nY < 0 || nX >= m || nY >= n)	
				continue;
			
			if(map[nX][nY] == 0)		
				dfs(nX, nY);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		
		m = Integer.parseInt(st.nextToken());	  // M×N 크기의 모눈종이
		n = Integer.parseInt(st.nextToken());	
		int k = Integer.parseInt(st.nextToken());	
		map = new int[m][n]; 	 
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 행열 주의 !
			for(int a = y1; a < y2; a++) {
				for(int b = x1; b < x2; b++) {
					map[a][b] = 1;
				}
			}
		}

		// 전체map 안에서 0인 값에서 dfs 시작하고 cnt 다끝나면 pq에 넣기 
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0) {
					cnt = 0;
					dfs(i,j);
					pq.offer(cnt);
				}
				
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}

}
