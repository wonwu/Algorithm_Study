/*
PG_3진법 뒤집기

char to int: 아스키 코드 이용 (문자 - '0')

3의 i제곱 Math.pow(3, i);

StringBuffer sb = new StringBuffer();
sb.append(num);
sb.toString();

*/

class Solution {
    // 10 > 반전된 3진법
    public String ternary(int n){
        StringBuffer sb = new StringBuffer();
        while(n > 0){
            int num = n % 3;
            n /= 3;
            sb.append(num);
        }
        
        return sb.toString();
    }
    
    public int solution(int n) {
        int answer = 0;
        
        // 반전된 3진법 결과
        // 압뒤 반전 할 필요x (위에서 나머지 순으로 문자열 생성하기)
        String t = ternary(n);
        
        // 10진법
        // char to int: 아스키 코드 이용 (문자 - '0')
        int len = t.length();
        for(int i = len - 1; i >= 0 ; i--){
            if(t.charAt(len - 1 - i)=='0')    continue;
            answer += Math.pow(3, i) * (t.charAt(len - 1 - i) - '0');
            System.out.println(answer);
        }

        return answer;
    }
}
