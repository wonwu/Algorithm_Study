/*
< 정렬 > 

[ 배열 자르기]
int[] arr1 = {0,1,2,3,4,5};

1. Arrays.copyOfRange() 
    int[] arr1 = Arrays.copyOfRange(arr, 0, 3);    // [0,1,2]
 
2. System.arraycopy();
    System.arraycopy(originArray, originStartIdx, copyArray, copyStartIdx, copyCnt);

[ ArrayList vs Array ]
ArrayList<Integer> array = new ArrayList<>();
    - 목록 크기 제한x 
    - 계속 원소 추가 가능
    
[ ArrayList<Integer> to Array int[] 변환 ]
int[] arr1 = array.stream().mapToInt(i -> i).toArray();

[ length() vs size() ]
- array
- ArrayList

*/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        
        // 반복 횟수 : commands 길이
        // System.out.println(commands.length);
        int len=commands.length;
        for(int i=0; i<len; i++){
            int targetIdx = commands[i][2]-1;
            
            // arr[] : commands[i][0]-1 ~ commands[i][1]-1
            int startIdx = commands[i][0]-1;
            int endIdx = commands[i][1];
            int[] copyArr = Arrays.copyOfRange(array, startIdx, endIdx); 
            
            // 정렬 후 
            Arrays.sort(copyArr);
            
            // answer에 추가 : to int[]
            answerList.add(copyArr[targetIdx]);
            
        }
        // System.out.println(answerList.toString());
        
        // 방법1 : 	통과 (0.48ms, 74.5MB)
        answer = new int[answerList.size()];
        for(int i=0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        // 방법2 : 	통과 (2.41ms, 67.3MB)
        // answer = answerList.stream()
        // .mapToInt(Integer::intValue)
        // .toArray();
        
        // 불통 incompatible types: inference variable T has incompatible bounds (int,Object / Integer)
        // answer = answerList.toArray(new Integer[0]);  (x)
        
        return answer;
    }
}