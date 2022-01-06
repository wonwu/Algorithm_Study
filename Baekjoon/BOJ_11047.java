package week6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 동전0
 * https://www.acmicpc.net/problem/11047
 * 
 * 출력
 * K원을 만드는데 필요한 동전 개수의 최솟값
 *  
 * 알고리즘
 * 큰 동전 단위부터 나눠주기
 * 
 */
public class BOJ_11047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	
		int k = Integer.parseInt(st.nextToken());	
		int[] arr = new int[n];	
		
		// 큰 단위가 앞에 오도록
		for(int i = n-1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int i = 0;
		while(k > 0) {
			if(k >= arr[i]) {
				cnt += k / arr[i];;
				k = k % arr[i];
			}
			i++;
			System.out.println(k);
		}

		System.out.println(cnt);
	}

}
