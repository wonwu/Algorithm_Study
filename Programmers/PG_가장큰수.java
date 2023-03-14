import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // numbers 정렬 (max 1000개)
        Arrays.sort(numbers);
        // no suitable method found for sort(int[],Comparator<Object>)
        // Arrays.sort(numbers, Collections.reverseOrder()); (x)
        
        
        // int to string
        // 이어붙이기 
        StringBuilder sb = new StringBuilder();
        for(int i=numbers.length-1; i>=0; i--){
            sb.append(String.valueOf(numbers[i]));
        }

        
        // StringBuilder to String
        answer = sb.toString();
        return answer;
    }
}