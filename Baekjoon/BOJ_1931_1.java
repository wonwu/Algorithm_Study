package week6_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 회의실 배정
 * https://www.acmicpc.net/problem/1931
 * 
 * 출력
 * 최대 사용할 수 있는 회의의 최대 개수
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다
 * 
 * 알고리즘
 * Room 클래스 정의 : start, end
 * 정렬기준은 1. end 오름차순	 2. start 오름차순
 * 이전 end시간과 지금 start시간 가능한지 체크
 * 
 */

class Room implements Comparable<Room>{	  
	//Comparable 인터페이스를 Room이 구현하면 정렬 사용가능
		int start;
		int end;
		
		Room(int s, int e) {
			this.start = s;
			this.end = e;
		}

		public int getStart() {
			return this.start;
		}
		
		public int getEnd() {
			return this.end;
		}
		
		@Override
		// 1. 종료시간 빠른순   2. 시작시간 빠른순
		public int compareTo(Room o) {
			return this.end == o.end ? this.start - o.start : this.end - o.end;
//			if(getEnd() == o.getEnd()) {
//				return getStart() - o.getStart();
//			}
//			return getEnd() - o.getEnd();

		}
	}
	
public class BOJ_1931_1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());	
		List<Room> room = new ArrayList<>(n);					
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			room.add(new Room(s,e));
		}
		
		Collections.sort(room);
		
//		for(Room r : room) {
//			System.out.println(r.getStart() + " " + r.getEnd());
//		}
//		System.out.println();
		
		int cnt = 0;
		int prevEnd = 0;;
		for(Room r : room) {			
			if(prevEnd <= r.getStart()) {
				//System.out.println(r.getStart() + " " + r.getEnd());
				prevEnd = r.getEnd();	//갱신
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}

