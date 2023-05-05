import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		int[] rslt;
		int s1 = 0; int s2 = 0; int s3 = 0;

		int[] p1 = new int[] {1, 2, 3, 4, 5};
		int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for(int i = 0; i < answers.length; i++){
			if(answers[i] == p1[i%5]) s1++;
			if(answers[i] == p2[i%8]) s2++;
			if(answers[i] == p3[i%10]) s3++;
		}

		int max = Math.max(Math.max(s1, s2), s3);
		if(s1 == s2 && s2 == s3) {
			rslt = new int[] {1,2,3};
		}
		else if(max == s1){
			if(max == s2) rslt = new int[] {1,2};
			else if(max == s3) rslt = new int[] {1,3};
			else    rslt = new int[] {1};
		}
		else if (max == s2){
			if(max == s3) rslt = new int[] {2,3};
			else    rslt = new int[] {2};
		}
		else {
			rslt = new int[] {3};
		}

		// 가장 큰 값 알고 --> 그 개수 알아야 --> 배열 크기 지정 --> 배열 값 대입
		return rslt;
	}
}