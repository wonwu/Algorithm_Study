import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = ""; int idx = 0;
        StringBuilder sb = new StringBuilder();
        //StringTokenizer stk = new StringTokenizer(s," ");
        //String[] st = new String[stk.countTokens()];        
		String[] st = s.split(" ", -1);
        /*while(stk.hasMoreTokens()){
		    st[idx++] = stk.nextToken();
	    }*/
        for(int i = 0; i < st.length; i++){
            String[] w = st[i].split("");
            for(int j = 0; j < st[i].length(); j++){
                if(j % 2 == 0) {
                    sb.append(w[j].toUpperCase());
                }
                else{
                    sb.append(w[j].toLowerCase());
                }
            }
            if(i != st.length - 1){
                sb.append(" ");
            }
        }
        answer = sb.toString();
        return answer;
    }
}