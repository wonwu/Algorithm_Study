import java.util.HashMap;
import java.util.Map.Entry;

/*
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 
서로 다른 옷의 조합의 수를 return
*/

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1; 
        HashMap<String, Integer> map = new HashMap<>();	
        
        for(int i = 0; i < clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1]) +1);
            }
            else{
                map.put(clothes[i][1], 1);
            }
        }
      
       for(Entry<String, Integer> e : map.entrySet() ) {
            answer *= (e.getValue() +1);
        }
        return answer -= 1;
    }
}
