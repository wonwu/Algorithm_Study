import java.util.Arrays;

/*
체육복
전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
체육수업을 들을 수 있는 학생의 최댓값을 return

분실한 학생이 여벌체육복을 갖고 있는 경우에는 
여벌 체육복 있는 학생 리스트 reserve에서 먼저 제외하기!
*/

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);      
        Arrays.sort(reserve);
      
        // 여벌을 2벌 가질경우 도난후 못빌려줌
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                    if(lost[i] == reserve[j]) { 
                        reserve[j] = -1;
                        lost[i] = -1;
                        answer++;
                        break;
                    }
            }
        }
        
        for(int i = 0; i < lost.length; i++){
            if(lost[i] == -1) continue;
            for(int j = 0; j < reserve.length; j++){
                    if(lost[i] + 1 == reserve[j]) {
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
                    else if(lost[i] - 1 == reserve[j]) {
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
            }
        }
        return answer;  // 체육수업을 들을 수 있는 학생의 최댓값
    }
}
