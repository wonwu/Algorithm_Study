import java.util.*;

/*
해시맵 hm에 참여한 사람 이름을 key, 동명이인 명수를 value로 넣기
완주한 사람들 이름을 key로 한 value의 값들을 -1씩 빼주기
value가 0이 아닌 사람 리턴

hm.getOrDefault(p,0): 키가 p인 값 반환, 없으면 0 반환
*/

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();  // 선수이름, 동명이인 인원수 
        
        for(String p : participant){
            // hm.getOrDefault(p,0) : HashMap hm에 p라는 키의 값 반환, 없으면 0 반환 (동명이인 카운트위해)
            hm.put(p, hm.getOrDefault(p,0) + 1);
            
            // if(hm.get(p) == null){
            //     hm.put(p, 1);
            // }
            // else{
            //     hm.put(p, hm.get(p)+1);
            // }
        }
        
        for(String c : completion){
            hm.put(c, hm.get(c)-1);
        }
        
        for(String key : hm.keySet()){
            if(hm.get(key) != 0){
                answer = key;
            }
        }
        
        return answer;
    }
}
