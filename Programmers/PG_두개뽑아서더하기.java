/*
시도01 : 55.6 / 100.0
조합o : 중복 허용x (해시)
오름차순 정렬

*중복 제거 방법*
- Set
--------------------------
시도02 : 


*/
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    
    public int[] solution(int[] numbers) {
        int answer[];
        
        
        
        return answer;
        
    }
    
//     // 조합 - 백트래킹 이용해 구현 
//     public void pick(int[] n, boolean[] visited, int start, int p, HashSet<Integer> set){
//         // 2개 다뽑음
//         if(p == 0){
//             int sum = 0;
//             for(int i = 0; i < visited.length; i++){
//                 if(visited[i])  sum += n[i];
//             }
//             set.add(sum);
//            return; 
//         }
//         else{
//             for(int i = start; i < n.length; i++){
//                 visited[i] = true;
//                 pick(n, visited, i+1, p-1, set);
//                 visited[i] = false;
//             }
//         }
//     }
    
//     public int[] solution(int[] numbers) {
//         boolean[] visted = new boolean[numbers.length];
//         HashSet<Integer> set = new HashSet<Integer>();
        
//         pick(numbers, visted, 0, 2, set);
        
//         // set to int[]
//         Integer[] a = set.toArray(new Integer[0]);
//         int answer[] = Arrays.stream(a).mapToInt(Integer::intValue).toArray(); 
        
//         return answer;
//     }
}