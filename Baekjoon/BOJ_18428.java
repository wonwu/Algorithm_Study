package week7_DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 감시 피하기
 * https://www.acmicpc.net/problem/18428
 * BOJ연구소와 비슷
 * 
 * 조건)
 * 학생 S, 선생 T, 장애물 O
 * 선생은 상하좌우 장애물전까지 다 봄 (장애물 뒤의 학생은 안보임)
 * 장애물 3개 설치해 모든 학생들이 선생 감시 피하도록 할 수 있는지 여부 출력 YES NO
 * 
 * 접근법)
 * 1. 완전탐색으로 빈칸인 X에 장애물 3개 설치
 * 2. 선생 T 위치에서 상하좌우 탐색 --> S 안만나면 YES return
 * 
 * ** 상하좌우 ** x,y값 변화 주의 !
 * 
 */
public class BOJ_18428 {

	static char[][] map;
	static char[][] copy;
	static int N;
	static boolean avoidable;	
	
	public static void printObject() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copy[i][j] == 'O')
					System.out.print("[" + i + "," + j + "] ");
			}
		}
		System.out.println();
	}
	
	public static void setObject(int cnt) {
		if(cnt == 3) {
			if(avoidable == true) return;		// 한번이라도 모든 학생들이 선생 감시 피하는 경우 존재하면 
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					copy[i][j] = map[i][j];
				}
			}
			//System.out.println("장애물3개 설치완료");
			//printObject();
			checkT();	      // 각 선생 위치에서 학생 확인
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if( map[i][j] == 'X') {
					map[i][j] = 'O';
					cnt++;
					setObject(cnt);
					map[i][j] = 'X';
					cnt--;
				}
			}
		}
	}
	
	public static void checkT() {
    // 장애물 설치 후 확인 전에 항상 true로 초기화 
		avoidable = true;			
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copy[i][j] == 'T') {
					checkS(i,j); 	// 모든 학생 감시 피할 수 있으면
				}
			}
		}
	}
	
	// 선생위치에서 상하좌우에 학생 보이는지 체크
	public static void checkS(int x, int y) {	
		
		int nextX = x, nextY = y;
    
		// 우
		nextY = y + 1;          // 미리 하나 더해주고
		while(nextY < N) {	    // 범위 체크   		
			
			if(copy[x][nextY] == 'O') break;	// 장애물 만나면 탈출
			if(copy[x][nextY] == 'S') {		    // 학생 걸림
				avoidable = false;
				break;
			}
			nextY += 1;
		}
		// 좌
		nextY = y - 1;
		while(avoidable == true && nextY >= 0) { // 위의 반복문에서 학생 만났을 경우 이미 avoidable은 false이므로 확인불필요		
			
			if(copy[x][nextY] == 'O') break;
			if(copy[x][nextY] == 'S') {		// 학생 걸림
				avoidable = false;
				break;
			}
			nextY -= 1;
		}
		// 상
		nextX = x - 1;
		while(avoidable == true && nextX >= 0) {	
			
			if(copy[nextX][y] == 'O') break;
			if(copy[nextX][y] == 'S') {		// 학생 걸림
				avoidable = false;
				break;
			}
			nextX -= 1;
		}
		//하
		nextX = x + 1;
		while(avoidable == true && nextX < N) {	
			
			if(copy[nextX][y] == 'O') break;
			if(copy[nextX][y] == 'S') {		  // 학생 걸림
				avoidable = false;
				break;
			}
			nextX += 1;
		}
		return;			
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		copy = new char[N][N];
		// 맵 입력받기
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] =  s.charAt(j*2);
			}
		}
		
		// 장애물 3개 설치 (완전탐색)
		setObject(0);
		if(avoidable == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
