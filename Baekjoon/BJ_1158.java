import java.util.LinkedList;
import java.util.Scanner;

public class BJ_1158_요세푸스문제_임지원 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();		// 사람 명수
		int k = sc.nextInt();		// K번째 사람을 제거
		
		for (int i = 1; i <= n; i++) {	// 입력
			que.offer(i);
		}
		
		int curr = k-1;				// k번째 사람의 인덱스
		sb.append("<");
		while(que.size() > 1) {
			int num = que.get(curr);
			que.remove(curr);
			sb.append(num + ", ");
			
			curr += k-1;
			while(true) {
				if(curr < que.size()) break;
				curr -= que.size();
			}

		}
		sb.append(que.peek() + ">");
		System.out.println(sb);   // <3, 6, 2, 7, 5, 1, 4>
	}

}
