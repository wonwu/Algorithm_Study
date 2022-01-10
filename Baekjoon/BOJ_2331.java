package week7_DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
 * 반복수열
 * https://www.acmicpc.net/problem/2331
 * 
 * 출력
 * 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수
 * 
 * 알고리즘
 * 1. 수열 구하기 -> HashSet, ArrayList에 저장
 * 2. 중복값이면 반복분 탈출, ArrayList인덱스 리턴
 */
public class BOJ_2331 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();	//인덱스 계산 위해
		HashSet<Integer> set = new HashSet<>();		//중복확인 위해 HashSet
		
		int a = sc.nextInt();
		int p = sc.nextInt();	
		 
		list.add(a);
		set.add(a);
		
		while(true) {
			int num = 0;
			while(a>0) {
				num += Math.pow(a % 10, p);
				a /= 10;
			}
			
			if(set.contains(num)) { 
				System.out.println(list.indexOf(num));
				break;
			}
			
			set.add(num);
			list.add(num);
			a = num;
		}
	}
	
}
