// 풀이 01: String.valueOf(Arrays.asList(stringToNum).indexOf(num))
//          s.toCharArray(), StringBuilder

// 풀이 02: s.replaceAll(stringToNum[i], Integer.toString(i));
//          stringToNum 길이만큼 반복문

import java.util.Arrays;

class Solution {
    public String change(String num){
        // 숫자에 대응되는 영단어
        String[] stringToNum = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        
        // 자바 배열에서는 indexOf()를 지원하지 않고 ArrayList자료구조에서만 지원 
        // int to String
        return String.valueOf(Arrays.asList(stringToNum).indexOf(num));
    }
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        char[] n = s.toCharArray();
        int len = s.length();
        String num = "";
        
        for(int i=0;i<len;i++){            
            // 숫자인 경우 
            if('0' <= n[i] && n[i] <= '9'){           
                sb.append(String.valueOf(n[i]));
            }
            // 영문자인 경우 
            else{
                num += String.valueOf(n[i]);
                if(!change(num).equals("-1")){
                    sb.append(change(num));
                    num = "";
                }
            }
        }
        
        return answer = Integer.parseInt(sb.toString());
    }
}