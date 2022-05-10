// PG_음양 뒤집기
// 삼항연산자

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < signs.length; i++){
            answer += absolutes[i] * (signs[i]? 1: -1);
        }
        
//         int plus = 0;
//         int minus = 0;
        
//         for(int i = 0; i < signs.length; i++){
//             if(signs[i] == true) plus += absolutes[i];
//             else    minus += absolutes[i];
//         }
//         answer = plus - minus;      
        return answer;
    }
}
