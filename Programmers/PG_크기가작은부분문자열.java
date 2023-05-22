// substring 
// Long.parseLong 제한사항 확인 필

class Solution {
     
    public int solution(String t, String p) {
        int answer = 0; //  작거나 같은 것이 나오는 횟수
        int pLen = p.length();
        int tLen = t.length(); 
        long compareP = Long.parseLong(p);
        
        for(int i=0;i<=tLen-pLen;i++){
            // String to Long 
            long rslt = Long.parseLong(t.substring(i,i+pLen));
            if(compareP >= rslt){
                answer++;
            }
        }
        return answer;
    }
}