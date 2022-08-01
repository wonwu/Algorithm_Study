import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244 {

	static String[] lights;		// 스위치의 상태
	static int[][] std;			// 학생 성별, 받은 숫자
	private static void printLights(String[] l) {
		for (int i = 0; i < l.length; i++) {
			if(i != 0 && i % 20 == 0) System.out.println();
			System.out.print(l[i] + " ");
		}
	}
	
	private static void changeLights(String[] l, int[][] std) {
		for (int i = 0; i < std.length; i++) {
			if(std[i][0] == 1) {						// 남학생 : 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다
				for (int j = 0; j < l.length; j++) {
					if ((j+1) % (std[i][1]+1) == 0) {
						if(l[j].equals("1")) l[j] = "0";
						else l[j] = "1";
					}
				}
			}
			else { // 여학생 : 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 스위치의 상태를 모두 바꾼다
				l[std[i][1]] = l[std[i][1]].equals("1") ? "0" : "1";
				int idx = std[i][1];
				int k = 1;
				while(idx - k >= 0 && idx + k < l.length) {
					if(l[idx - k].equals(l[idx + k])) {
						if(l[idx - k].equals("1")) {
							l[idx - k] = "0";
							l[idx + k] = "0";
						}
						else {
							l[idx - k] = "1";
							l[idx + k] = "1";
						}
					}
					else break;
					k++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	// 스위치 개수
		String s = br.readLine();					// 각 스위치의 상태 (켜져 있으면 1, 꺼져있으면 0)
		lights = s.split(" ");
		
		int studentNum = Integer.parseInt(br.readLine());	// 학생수
		std = new int[studentNum][2]; 						// 학생의 성별(남학생은 1로, 여학생은 2), 학생이 받은 수
		
		for (int i = 0; i < studentNum; i++) {
			s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);	// default delim 공백으로 구분 
			std[i][0] = Integer.parseInt(st.nextToken());
			std[i][1] = Integer.parseInt(st.nextToken())-1;	// 인덱스
		}
		
		changeLights(lights, std);	// 스위치 바꾸기
		
		printLights(lights);		// 스위치의 상태 한 줄에 20개씩 출력(켜져 있으면 1, 꺼져있으면 0)
	}

}
