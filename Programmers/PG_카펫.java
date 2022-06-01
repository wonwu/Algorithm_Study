import java.util.*;
// Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 
// 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return

/*
brown n개, yellow m개 --> 전체 카펫 크기 --> 카펫 가로, 세로 반환
예시. 
전체 타일 수 = 36 
brown 타일의 개수 기준으로 false, true 판별
       (3+4)*2 -4 = 10
       if ( (가로 + 세로)*2 -4 == brown)    true;

가로, 세로는 최소 3이상
세로 길이 <= 가로 길이 

*/
 
  
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow; //전체 타일 개수
        int w = 0; int h = 0;   //가로, 세로 길이
                                

        for(int i=3; i <= n/3; i++){
            if(n % i == 0){
                h = i; w = n / i;
                if( (w + h)*2 -4 == brown ){
                    answer = new int[] {w, h};
                    break;
                } 
            }
        }
        return answer;
    }
}
