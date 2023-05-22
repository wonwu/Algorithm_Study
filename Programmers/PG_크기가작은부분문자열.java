class Solution {
    public int solution(String t, String p) {
        int answer = 0; //  작거나 같은 것이 나오는 횟수
        
        int len = p.length();
        char[] num = t.toCharArray();
        
        for(int i=0;i<=t.length()-len;i++){
            int rslt = 0;
            int idx = len-1;
            for(int j=i;j<j+len;j++){
                rslt += (num[i]-'0')*Math.pow(10,idx--);
            }
            if(Integer.parseInt(p) >= rslt){
                answer++;
            }
            
        }
        return answer;
    }
}