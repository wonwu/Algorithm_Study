import java.util.HashMap;

// 방법03)  answer[i] = i-map.getOrDefault(word[i],i+1);
// 찾는 key가 존재한다면 찾는 key의 value를 반환하고 
// 없거나 null이면 default 값을 반환
// ex. 해당 키의 값을 합계로 사용
// for(String key : abc) {
//         	hm.put(key, hm.getOrDefault(key, 0) + 1); 
//         }

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
//      시도02) hashmap(알파벳, 인덱스)
        char[] word = s.toCharArray();
        HashMap<Character,Integer> hp = new HashMap<Character,Integer>();
        answer = new int[s.length()];

        for(int i=0;i<s.length();i++){
            // key값 있는 경우 
            if(hp.containsKey(word[i])){
                 answer[i] = i-hp.get(word[i]);
                 // 해시 값 갱신
                 hp.put(word[i],i);                
            // key값 없는 경우
            }else{
                answer[i] = -1;
                hp.put(word[i],i);
            }
        }
   
         // -------------시도01) 실행 시간이 10.0초를 초과------------
//         이중반복문, 앞에서부터 앞의 문자들과 비교하면서 answer에 값 저장
        
        return answer;
    }
}