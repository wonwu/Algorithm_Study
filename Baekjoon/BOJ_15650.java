import java.util.Scanner;

/*
 * N과 M(2)
 * https://www.acmicpc.net/problem/15650
 * 
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.

 */
public class BOJ_15650 {

	static int n,m;
	static int[] arr;
	static int[] picked;
	static boolean[] visited;
	static StringBuilder sb;
	
									// 지금까지 뽑은 개수 / 지금 뽑아야할 원소인덱스
	public static void permutation(int now, int at) {
		if(now == m) {
			for(int num : picked) {
				sb.append(num + " ");
			}

			sb.append("\n");
			return;
		}
		
		for(int i = at; i < n; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				picked[now] = arr[i];
				permutation(now+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt(); // 뽑아야하는 총개수
		arr = new int[n];
		picked = new int[m];
		visited = new boolean[n];
		sb = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		// 지금까지 뽑은 개수 / 지금 뽑아야할 원소인덱스
		permutation(0, 0);
		System.out.println(sb);

	}
	
}
