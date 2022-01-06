package week6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 회의실 배정
 * https://www.acmicpc.net/problem/1931
 * 
 * 출력
 * 최대 사용할 수 있는 회의의 최대 개수
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다
 * 
 * 알고리즘
 * 2차원배열 이용해 start, end 저장
 * 정렬기준은 1. end 오름차순	 2. start 오름차순
 */

public class BOJ_1931_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		int[][] room = new int[n][2];			
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			room[i][0] = Integer.parseInt(st.nextToken());	// 시작시간
			room[i][1] = Integer.parseInt(st.nextToken()); //  종료시간
		}
		
		// compare 재정의
		Arrays.sort(room, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] r1, int[] r2) {
				// 1. 종료시간 빠른순   2. 시작시간 빠른순
				if(r1[1] == r2[1]) {
					return r1[0] - r2[0];
				}
				return r1[1] - r2[1];
			}
		});
		
		int cnt = 0;
		int prevEnd = 0;;
		for(int i = 0; i < n; i++) {
			// 이전 종료시간보다 현재 시작시간이 크거나 같은 경우 갱신
			if(prevEnd <= room[i][0]) {
				prevEnd = room[i][1];	
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}

