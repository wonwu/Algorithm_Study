import java.util.*;
/*

조이스틱
만들고자 하는 이름 name이 매개변수로 주어질 때, 
이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하는 solution 함수

ABA , A가 많은 경우 돌아서 가는 경우를 고려해야
*/

// 이동방향 체크
class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len-1; // 좌우이동 횟수 (그냥 처음부터 오른쪽 끝까지)
       
        for(int i = 0; i < len; i++){
            char c = name.charAt(i);

            // 상하횟수
            answer += Math.min(c-'A', 'Z'-c+1); 
          
            // 좌우는 연속된 A에 따라 좌우이동의 최소움직임이 달라짐
            int next_idx = i+1; 
            while(next_idx < len && name.charAt(next_idx) == 'A'){
                    // 연속된 A 나올 경우
                    next_idx++;
            }
          
            // next_idx : 연속된 A가 끝난 후의 문자 인덱스
            // (len-next_idx) : 연속된 A 지나고 남은 문자 개수
            int tmp = i + (len-next_idx) + Math.min(i, len-next_idx);
            // 방향 바꾸는거 고려x거와 비교
            move = Math.min(move, tmp); 
        }
      
        answer += move;
        return answer;
    }
}
