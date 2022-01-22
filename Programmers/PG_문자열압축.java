/*
PG_문자열 압축

[핵심] String에서 원하는 문자열 추출 
1) String substring(int a, int b) : 현재 문자열 객체에서 a부터b전까지 문자열
2) String substring(int index) : 문자열 index부터 끝까지 문자열 
   
[알고리즘]
1. 문자열 길이 1인 경우 압축x, 1로 반환 
2. 단위(i) 범위는 1 ~ s.length()/2    --> 압축 위해 
3. 문자열 단위(i)로 압축이 가능한 범위는 s.length() / i 
4. 마지막에 전에 자른 문자열과 같은 경우로 압축되는 경우, 붙이지 못한 문자열 붙이기
5. 압축 못하는 s.length() % i는 그대로 붙여줘야 

*/

class Solution {
    public int solution(String s) {
        // 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이
        int answer = Integer.MAX_VALUE;
        
        // 문자열 길이 1인 경우 압축x, 1로 반환
        if(s.length() == 1) return 1;
        
        // 가능한 압축 단위i의 범위 (1~s.length()/2)
        for(int i = 1; i <= s.length()/2; i++) {
            
            // 압축 후의 문자열
            String rslt = "";
            // 비교할 자른 문자열
            String tmp = "";
            // 자른 문자열 개수
            int cnt = 1;
            
            // 문자열 단위(i)로 압축이 가능한 범위는 s.length() / i 
            for(int j = 0; j < s.length()/i; j++){  
              
                // 전에 자른 문자열tmp와 현재 자른 문자열 비교
                if(tmp.equals(s.substring((j*i),(j*i)+i))){
                    cnt++;
                }
                else{
                    // 자른 문자열 개수(압축이 가능한 경우가 존재)
                    if(cnt > 1){
                        // 자바에서는 덧셈 연사자를 진행할때, 
                        // 연산자중 한 쪽이 String 형이면 나머지 쪽을 String 형태로 변환 한 다음 두 String형 문자열을 결합
                        rslt += cnt + tmp; 
                        cnt = 1;
                    }
                    else{
                        // 압축 못하면 그대로 붙여줘야 
                        rslt += tmp;                        
                    }
                }

                tmp = s.substring(j*i,(j*i)+i);
            }
            
            // 마지막에 전에 자른 문자열과 같은 경우로 압축되는 경우, 붙이지 못한 문자열 붙이기 
            if(cnt > 1){
                    rslt += cnt + tmp; 
                    cnt = 1;
            }
            else{
                // 압축 못하면 그대로 붙여줘야 
                rslt += tmp;                        
            }
            
            // 압축 못하는 나머지 s.length() % i 는 그대로 붙여줘야
            if(s.length() % i != 0){
                rslt += s.substring(s.length() - (s.length() % i));
            }
            
            answer = Math.min(answer, rslt.length());
        }
        
        return answer;
    }
}
