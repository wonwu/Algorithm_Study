import java.util.Scanner;

public class BJ_17478 {

	static String s1 = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static String s2 = "\"재귀함수가 뭔가요?\"\n";
	static String s3 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static String s4 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String s5 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String s6 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String s7 = "라고 답변하였지.\n";
	
	static String s = "____";
	
	public static void Recursion(int n, int k) {
		String add = "";
		
		int i = k; 	//앞에 붙는 언더바 횟수
		while(i-- > 0) {
			add += s;
		}
		
		System.out.print(add + s2);
		
		if(n == 0) {
			System.out.print(add + s6);
			System.out.print(add + s7);
			return;
		}
		else {
			System.out.print(add + s3);
			System.out.print(add + s4);
			System.out.print(add + s5);
			Recursion(n-1, k+1);
		}
		System.out.print(add + s7);

	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 재귀 횟수
		
		System.out.print(s1);
		Recursion(n, 0);		// 재귀 횟수, 앞에 붙는 언더바 횟수	
	}

}
