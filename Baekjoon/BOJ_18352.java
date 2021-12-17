package week7_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 특정 거리의 도시찾기
 * https://www.acmicpc.net/problem/18352
 * 
 * 출력)
 * 거리가 1인 N개의 도시, M개 간선
 * X부터 시작한 최단거리 K인 모든 도시번호 출력, 없으면 -1
 * 
 * 접근법)
 * 노드가 30만까지 들어올 수 있으므로 연결리스트로 풀이
 * 거리가 1 --> BFS
 * 만약 거리1 아니었으면 다익스트라
 * 
 */
public class BOJ_18352 {

	static ArrayList<Integer>[] graph;
	static int[] distance;
	
	static void bfs(int x, int k) {
		Queue<Integer> q = new LinkedList<>();
		// 큐에 시작정점 더해준 후, 방문 표사
		q.offer(x);
		
		while(!q.isEmpty()) {
			int tmp = q.poll();		// 큐에서 노드 하나 꺼내기
			
			//해당 노드의 인접노드 중에서 방문하지 않은 ‘모든 노드’를 큐에 삽입하고 방문처리
			for(int i : graph[tmp]) {	
				// 방문안한 도시면 이전도시까지의 거리+1로 초기화
				if(distance[i] == 0) {
					distance[i] = distance[tmp]+1;
					q.offer(i);
				}
			}
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int n = Integer.parseInt(st.nextToken());	// 도시의 개수
		int m = Integer.parseInt(st.nextToken());	// 도로의 개수
		int k = Integer.parseInt(st.nextToken());	// 거리 정보 
		int x = Integer.parseInt(st.nextToken());	// 출발 도시의 번호 
		graph = new ArrayList[n+1];
		distance = new int[n+1];
		
		// 연결리스트 초기화
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		// 연결리스트 생성
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a--> b 도로 존재, 단방향 그래프
			graph[a].add(b);
		}
		
		// X에서 출발
		bfs(x, k);
		
		//System.out.println(Arrays.toString(distance));

		boolean found = false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < distance.length; i++) {
      // x로 시작하고 x로 끝나는 경우 제외
			if(distance[i] == k && i != x) {	
				sb.append(i + "\n");
				found = true;
			}
		}
		
		if(found)
			System.out.println(sb);
		else
			System.out.println("-1");
	}


}
