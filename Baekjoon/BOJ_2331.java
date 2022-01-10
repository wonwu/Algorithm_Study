package week7_DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_2331 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int p = sc.nextInt();	
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>(); 
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
