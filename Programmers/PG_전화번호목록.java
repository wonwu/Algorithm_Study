import java.util.HashMap;
import java.util.Arrays;
import java.util.Map.Entry;

/*
전화번호를 담은 배열 phone_book이 solution 함수의 매개변수로 주어질 때, 
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false 
그렇지 않으면 true를 return
*/

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true; 
        Arrays.sort(phone_book);
        HashMap<Integer, String> map = new HashMap<>(phone_book.length);       // 번호를 Value에
      
        for(int i = 0; i < phone_book.length; i++){
            map.put(i, phone_book[i]);
        }
        
        for (Entry<Integer, String> e : map.entrySet() ) {
            if(e.getKey() == map.size()-1) break;       // 마지막 Key값이면 비교대상 없으므로 false
            if((map.get(e.getKey() + 1)).startsWith(e.getValue())){
                answer = false;
                break;
            } 
        }
        return answer;
    }
}
