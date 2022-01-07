package week6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 30
 * https://www.acmicpc.net/problem/10610
 * 
 * 입력
 * 10만개 이하의 자릿수 가진 n
 * 
 * 출력
 * 30의 배수가 되는 가장 큰 수를 (포함된 모든 수를 이용하기)
 * 존재하지 않는다면, -1을 출력
 * 
 * 알고리즘 : 그리디 + 문자열
 * 1. 입력 string 숫자를 자릿수를 인덱스로 갖는 int[]배열 num에 저장 (0~9개수 저장하는 배열)
 * 2. 30의 배수 판별위해 모든 자릿수 sum에 더하기
 * 3. 30의 배수인지 확인 -> 맞다면 '문자열'로 출력
 * 
 * 10만개 이하의 자릿수 가진 n 
 * 정수형 타입인 int 나 실수형 타입인 long 이나 10^5개의 자리수를 입력 받을 수 있는  자료형은 없음
 * --> 입력을 문자열로 받기
 */
public class BOJ_10610 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();			// 입력받는 문자열
		int[] num = new int[10];	// 0~9까지 값의 개수 저장 

		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			num[n] += 1;
			sum += n;
		}
		 
		System.out.println(Arrays.toString(num));
		
		// 30의 배수 판벼: 각 자릿수 합이 3의 배구 && '0'이 존재해야
		StringBuilder sb = new StringBuilder();
		if(sum % 3 == 0 && str.contains("0")) {
			for(int i = 9; i >= 0; i--) {		// 30의 배수가 되는 가장 큰 수이므로 뒤에서부터
				while(num[i] > 0) {
					sb.append(i);
					num[i]--;
				}
				
			}
			System.out.println(sb.toString());
		}
		else {
			System.out.println("-1");
		}
	}

}
