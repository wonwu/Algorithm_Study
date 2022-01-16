package week5_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 탑
 * https://www.acmicpc.net/problem/2493
 * 
 * 조건)
 * 서로 다른 높이의 탑
 * 레이저 왼쪽으로 발사
 * 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 '단 하나의 탑'에서만 수신이 가능
 * 레이저 수신은 여러번 가능
 * 
 * 2중 반복문 시간초과
 * 
 * 알고리즘
 * 1. 탑의 높이를 입력받고, stack 비어있는지 확인 (입력과 동시에 진행)
 * 2. stack이 비어있지 않다면
 * 		2.1 이전 탑 높이가 현재 탑 높이보다 큰 경우 -> 수신가능
 * 		2.2 이전 탑 높이가 현재 탑 높이보다 작은 경우 -> 수신불가 -> stack.pop();
 * 3. stack이 비어있다면, 현재 탑의 신호를 받을 탑이 없으므로 0출력
 * 4. 입력받은 [탑 번호, 탑 높이] stack에 저장
 * 
 */
public class BOJ_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		// stack에 int형 배열 저장 : stack[0] 탑의 번호, stack[1] 탑의 높이
		Stack<int[]> stack = new Stack<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			// 현재 탑의 높이
			int now = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				// 수신가능 : 이전 탑 높이가 현재 탑 높이보다 큰 경우
				if(stack.peek()[1] >= now) {
					sb.append(stack.peek()[0] + " ");
					break;
				}
				else {
					stack.pop();
				}
			}
			
			// stack이 빈 경우 = 수신할 탑 없음
			if(stack.empty()) {
				sb.append("0 ");
			}
			// 다음 탑 비교위해 현재 탑의 번호와 높이 스택에 저장
			stack.push(new int[] {i+1, now});
			
		}

		System.out.println(sb);

	}
}
