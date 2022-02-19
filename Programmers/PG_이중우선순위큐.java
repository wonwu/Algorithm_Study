import java.util.PriorityQueue;
import java.util.Collections;
/*
PG_이중우선순위큐
s.substring(i) : 해당인덱스부터 ~ 끝까지
s.substring(beginIdx, endIdx) : beginIdx 인덱스부터 ~ endIdx-1까지

테스트1 : 연산 중에 숫자 삽입횟수와 삭제 횟수가 같은 경우, 모든 Queue가 비어있어야 하지만 수가 남아있는 경우 존재
    -> 해결: 숫자 삽입 횟수 == 삭제 횟수인 경우, 모든 Queue를 초기화

테스트2.6 : 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시 
    -> 해결 : 최댓값, 최솟값 삭제 시 각 큐 사이즈 > 0 확인 (빈큐가 아닌지 확인)
*/
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        // 최소힙 pq1, 최대힙 pq2
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        // 숫자 삽입횟수, 삭제 횟수
        int insertCnt = 0; 
        int delCnt = 0;
        
        for(int i = 0; i < operations.length; i++){
            String tmp = operations[i];
            if(tmp.charAt(0) == 'I'){
                // 삽입
                int n = Integer.parseInt(tmp.substring(2));
                pq1.offer(n);
                pq2.offer(n);
                insertCnt++;
            }
            else if(tmp.equals("D 1") && pq2.size() > 0){
                // 최댓값 삭제 + 빈 큐 여부 확인
                pq2.poll();
                delCnt++;
            }
            else if(tmp.equals("D -1") && pq1.size() > 0){
                // 최솟값 삭제 + 빈 큐 여부 확인
                pq1.poll();
                delCnt++;
            }
            
            // 숫자 삽입 횟수 == 삭제 횟수인 경우, 모든 Queue를 초기화
            if(insertCnt == delCnt) {
                pq1.clear();
                pq2.clear();
            }
        }
        // 숫자 삽입횟수보다 삭제 횟수가 더 많을 경우
        if(insertCnt <= delCnt) return answer;
        
        // 비어있지 않으면 [최댓값, 최솟값]을 return
        if(pq1.size() > 0 || pq2.size() > 0){
            answer[0] = pq2.peek();
            answer[1] = pq1.peek();            
        }
        
        return answer;
    }
}
