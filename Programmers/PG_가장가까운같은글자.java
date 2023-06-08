import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] word = s.split("");
        int[] ans = new int[word.length];

        ans[0] = -1;
        
        for (int i = 1; i < word.length; i++) {
            ans[i] = -1;
            for (int j = i-1; j >= 0; j--) {
                if (word[j].equals(word[i]) ) {
                    ans[i] = i-j;
                    break;
                }
            }
        }
        
        return ans;
    }
}​