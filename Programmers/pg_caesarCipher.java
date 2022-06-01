/*
시저암호

[핵심]
String -> char[]
: 모든 글자 char배열에 넣기
    char[] stringtochar = s.toCharArray();
  한 글자만
    s.charAt(i);

char[] -> String
: String.valueOf(stringtochar);

char -> ASCII
: (int)stringtochar[i]

ASCII 아스키코드
    A 65
    Z 90
    a 97
    z 122
    
[ 알고리즘 ]
1. 기존 문자가 대문자인지 소문자인지 확인 
2. n만큼 민 아스키값이 대문자 범위(65-90) 또는 소문자범위(97-122)인지 확인
3. 범위 밖이면, 따로 계산 

A...Z
a..b
*/

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] stringtochar = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
            char a = stringtochar[i];
            if(a == ' ') continue;
            
            stringtochar[i] += n; 
            int check = (int)stringtochar[i];
            
            if('a' <= a && a <= 'z' && check > 122) stringtochar[i] -= 26;
            else if('A' <= a && a <= 'Z' && check > 90) stringtochar[i] -= 26;
            
            // System.out.println(String.valueOf((int)stringtochar[i]));
        }
       
        return answer = String.valueOf(stringtochar);
    }
}