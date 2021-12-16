package week7_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 미로 탐색
 * https://www.acmicpc.net/problem/2178
 * 
 * 출력)
 * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 '최소'의 칸 수
 * 
 * 접근법)
 * 한줄씩 string으로 입력받아 문자 하나하나씩 숫자로 변환 (아스키코드)
 * 탐색할 때 다음에 밟을 칸에 현재 칸까지의 가중치를 더해주기 !
 */
public class BOJ_2178 {
	/*인접 행렬*/
	static int[][] map;
	static boolean[][] visited;
	static int N;	
	static int M;
	//static int cnt = 1;	
	static int[] dx = {-1, 1, 0, 0};	// x방향 : 상하
	static int[] dy = {0, 0, -1, 1};	// y방향 : 좌우
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();	// (x,y) 쌍의 int형 배열 
		
		q.offer(new int[] {x,y});	// 시작 정점
		
		// 큐가 빌 때까지 반복, 방문 정점 확인, 출력 후 큐에 넣어 순서대로 확인
		while(!q.isEmpty()) {
			int now[] = q.poll();		// 큐에서 노드 하나 꺼내기
			int nowX = now[0];
			int nowY = now[1];
			
			//해당 노드의 인접노드 중에서 방문하지 않은 ‘모든 노드’를 큐에 삽입하고 방문처리
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				// 미로 경계선 체크
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				
				// 이미 방문했거나 이동할 수 없는 칸인 0인 경우
				if(visited[nextX][nextY] || map[nextX][nextY] == 0) 
					continue;
				
				System.out.println(nextX + "/" + nextY);
				q.offer(new int[] {nextX, nextY});
				map[nextX][nextY] = map[nowX][nowY] + 1;
				visited[nextX][nextY] = true;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		map = new int[N][M];	        // 좌표 그대로 받아들이기 위해 +1해서 선언
		visited = new boolean[N][M];	// 초기값 false
		
		// 그래프 입력 받기
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0'; 	// char to int : 아스키코드 
			}
		}
		visited[0][0] = true;
		//dfs(1,1);
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
	}

}
