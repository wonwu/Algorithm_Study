package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호 {
	
	public static void main(String[] args) throws IOException {

		// 이 식의 값을 최소로  : -연산자 기준으로 문자열 자른 후, 끼고있는 숫자끼리 먼저 +계산 후 -> 빼주기
		// s -> StringTokenizer("-") -> StringTokenizer(next,"+")	
		// 수는 0으로 시작할 수 있음 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		st = new StringTokenizer(s,"-");	 // (5+3+6)-(1+5)-(7+1)	
		
		int ans = 0;
		boolean firstSum = true;			// 첫번재로 더한 그룹인지 여부
		
		while(st.hasMoreTokens()) {
			String next = st.nextToken();			
			StringTokenizer st2 = new StringTokenizer(next,"+");
			int sum = 0;
			
			while(st2.hasMoreTokens()) {
				sum += Integer.parseInt(st2.nextToken());
			}
			
			if(firstSum == true) ans = sum;
			else ans -= sum;
			
			firstSum = false;
		}
		
		System.out.println(ans);
		
	}
}
