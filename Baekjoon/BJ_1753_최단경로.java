import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
최단경로
: 다익스트라 (인접리스트)
- 시작정점에서 다른 모든 정점으로의 최단경로 구하는 알고리즘
거리가 최소인 정점 선택해 나가기 (그리디 기법)

 - 리스트 안에 리스트
 - ArrayList 사용 (LinkedList는 시간초과 나옴 : 저장될 대 각 노드들이 포인터로 연결되어있음)
*/
public class Main {
	
	private static final int INF = Integer.MAX_VALUE;
	public static ArrayList<Node>[] graph;
	public static int[] dis;
	public static int V;

	public static class Node implements Comparable<Node> {
		int idx;
		int weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		} // 가중치 적은 순 오름차순 정렬

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
			// Integer.compare(A, B) : A가 더 크면 양수, B가 더 크면 음수, 같으면 0
			// return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static void dijkstra(int s) {

		Queue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		q.offer(new Node(s, 0));
		dis[s] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll().idx;
			
			if(visited[cur]) continue;			
			visited[cur] = true;
			
			//dis 값 갱신 
			for (Node node : graph[cur]) {
				// 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고, 기존 최적해보다 유리하면 갱신
				if(dis[node.idx] > dis[cur] + node.weight) {
					dis[node.idx] = dis[cur] + node.weight;
					q.add(new Node(node.idx, dis[node.idx]));
				}
			}
				
		}
	}

	public static void main(String[] args) throws IOException { // 가중치(10이하) 있는 방향그래프 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 정점의 개수 V와 간선의 개수 E
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		// 시작 정점의 번호 K
		int K = Integer.parseInt(br.readLine()); // 최단 경로 저장
		dis = new int[V+1];
		
		// 입력받을 그래프 초기화
		graph = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		} 
		
		// 간선 정보 입력받기
		for (int i = 0; i < E; i++) {
			// u에서 v로 가는 가중치 w인 간선
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		} 
		
		// dis 배열을 INF로 초기화
		// 시작점을 제외한 노드의 거리 무한으로 초기화
		// 시작점 거리를 0으로 
		Arrays.fill(dis, INF); 
//		sb.append("0\n"); 
		
		dijkstra(K);
		
		// 시작점에서 다른 모든 정점으로의 최단 경로 구하기, 경로가 존재하지 않는 경우에는 INF 
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if(dis[i] == INF) {
				sb.append("INF\n");
			}
			else {
				sb.append(dis[i] + "\n");
			}
		}
		
		System.out.println(sb.toString()); 

	}
}
