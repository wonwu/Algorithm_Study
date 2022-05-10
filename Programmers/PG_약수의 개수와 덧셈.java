/* 
PG_약수의 개수와 덧셈

약수 개수 홀수인 것은 제곱수 여부
Math.sqrt() 메소드는 입력값과 출력값은 모두 double형

소수점 올림, 정수 반환
    Math.ceil(n) 
버림
    Math.floor(n)
반올림
    Math.round(n)
*/

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            // 제곱수인 경우 약수의 개수가 홀수
            if(Math.sqrt(i) - Math.floor(Math.sqrt(i)) == 0)
                answer -= i;
            else
                answer += i;   
        }
        
        return answer;
    }
}
