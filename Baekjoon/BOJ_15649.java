import java.util.Scanner;

/*
 * 백트래킹
 * N과 M(1)
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 : 중복없는 순열
 */

public class BOJ_15649 {

	public static void pick(int[] num, boolean[] picked, int n, int m, int p) {
		// m개 다 고른 경우 출력
		if(p == m) {
			for(int i = 0; i < n; i++) {
				if(picked[i] = true) {
					System.out.print(num[i] + " ");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < n; i++) {
			picked[i] = true;
			pick(num, picked, n, m, p+1);
			picked[i] = false;
		}	
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] num = new int[n];
		boolean[] picked = new boolean[n];		
		
		// 숫자배열, 뽑은 수 저장 배열, 총 숫자 개수, 뽑아야하는 개수, 뽑은 개수 
		pick(num, picked, n, m, 0);
		
	}

}
