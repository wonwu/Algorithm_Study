package week6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ATM
 * https://www.acmicpc.net/problem/11399
 * 
 * 출력
 * 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
 * 어떤 순서로 사람들을 줄 세워야하는지
 * 
 * 알고리즘 : 그리디
 * 3 1 4 3 2  : 32
 * 적게 걸리는 시간순으로 정렬(앞의 시간들은 반복해져 더해지므로)
 * 1 2 3 3 4
 * 0번 완료 = 1
 * 1번 완료 = 1 +2 = 3
 * 2번 완료 = 3(1+2) +3 = 6
 * 3전 완료 = 6((1+2)+3) +3 = 9
 * 4번 완료 = 9((1+2)+3)+3) +4 = 13
 */
public class BOJ_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	// 사람의 수 
		int[] arr = new int[n];						// 각 사람이 돈을 인출하는데 걸리는 시간
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int ans = arr[0];
		for(int i = 1; i < n; i++) {
			arr[i] += arr[i-1];
			ans += arr[i];
		}
		System.out.println(ans);
	}

}
