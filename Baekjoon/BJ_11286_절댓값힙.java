package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * N개의 연산
 * 입력 정수 != 0 : 정수 추가
 * 입력정수 == 0 : 정수 출력 & 제거 (만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력)
 * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력
 *
 */
public class BJ_11286_절댓값힙 {

	static int n;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 절댓값이 같으면 음수가 앞으로
				if(Math.abs(o1) == Math.abs(o2)) {
					return o1.compareTo(o2);
				}
				return (Integer.compare((Math.abs(o1)),(Math.abs(o2)))); // **** 절댓값이 다르면 음수가 앞으로 
			}
		}
		);
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				pq.add(num);	
			}
			else {
				if(pq.isEmpty()) {
					sb.append("0" + "\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			}
			
//			System.out.println("현재 = " + pq);
		}
		System.out.println(sb.toString());
		
	}

}
