package week7_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 * 
 * 출력)
 * 총 단지 수
 * 각 단지내 집의 수 으름차순 출력
 * 
 */
public class BOJ_2667 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	// 상항 좌우
	static int cnt;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			// 경계선 체크
			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
				continue;
			
			if(map[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
				cnt++;
				dfs(nextX, nextY);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();		// 각 단지 내 집의 수 넣기
		
		for(int i = 0 ; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					cnt = 1;
					//System.out.println("*");
					dfs(i, j);
					list.add(cnt);
				}
			}
			
		}
		
		Collections.sort(list);		// 오름차순
		
		System.out.println(list.size());	// 총 단지 개수
		for(Integer i : list) {
			System.out.println(i);
		}
	}

}
