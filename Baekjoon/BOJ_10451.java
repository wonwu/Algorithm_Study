package week7_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 순열 사이클
 * https://www.acmicpc.net/problem/10451
 * 
 * 출력)
 * N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수
 * 
 * 알고리즘)
 * 인덱스값 : 0번 1번 2번...
 * 배역 값 : 3 2 7 ...
 * 단방향그래프
 * 인접리스트 + visited
 */

public class BOJ_10451 {

	static List<Integer>[] map;
	static boolean[] visited;
	static int cnt;
	
	public static void dfs(int start) {
		
		//방문했으면 종료
		if (visited[start]) {
			return;
		}
		
		visited[start] = true;
		
		for (int i : map[start]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());	//테스트 케이스의 개수
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());	//순열의 크기 N 
			map = new ArrayList[n+1];					//연결리스트
			
			//초기화
			for (int j = 0; j <= n; j++) {
				map[j] = new ArrayList<>();
			}
			
			visited = new boolean[n+1];
			cnt = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				int end = Integer.parseInt(st.nextToken());
				// 단방향
				map[j].add(end);				
			}
			
			// 방문 안된 리스트 탐색
			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					dfs(j);
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);

	}   
 
}
