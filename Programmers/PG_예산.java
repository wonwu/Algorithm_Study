import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        // 최대 몇 개의 부서에 물품을 지원할 수 있는지 
        int answer = 0;
        
        // 예산 신청배열d 정렬
        Arrays.sort(d);
        
        for(int money : d){
            if((budget-=money) < 0) break;
            answer++;
        }
        return answer;
    }
}