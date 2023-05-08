/*
[내 풀이]
조합 : 백트래킹
배열 합 : 
방법01) Arrays.stream(arr).sum()   
    1.79ms, 73.4MB
    3.53ms, 70.3MB
방법02) int[] 
    0.34ms, 75.8MB
    0.39ms, 76.7MB

[크기 정리]
length : 배열 길이 (int[], String[])
length() : 문자열 길이 (String, StringBuilder)
size() : 컬렉션 프레임워크 타입의 길이 (ArrayList, Set)

[다른풀이]
삼중for문 

*/

import java.util.Arrays;

class Solution {
    static int ans=0;
    
    // private void print(int[] num){
    //     for(int i=0;i<num.length;i++){
    //            System.out.print(num[i] + ", ");
    //     }
    //     System.out.println();
    // }
    
    private void pick(int picked, int[] num, int[] pickedNum, int start){
        if(picked==3){
            int sum=0;
            if(Arrays.stream(pickedNum).sum()==0){
                ans++;
            }
            // for(int i=0;i<pickedNum.length;i++){
            //     sum+= pickedNum[i]; 
            // }
            // if(sum==0) {
            //     ans++;
            //     // print(pickedNum);
            // }
            return;
        }

        for(int i=start;i<num.length;i++){
            // pickedNum[i]=true;                   // boolean
            pickedNum[picked] = num[i];            
            pick(picked+1,num,pickedNum,i+1);     
            // pickedNum[i]=false;                  // boolean
        }
    }
    
    public int solution(int[] number) {
        int answer = 0;     // 삼총사를 만들 수 있는 방법의 수
        
        // 정렬 -> 정렬 후 백트래킹
        Arrays.sort(number);
        
        // 뽑은 수 담는 배열 
        int[] pickedNum = new int[3];
        // boolean[] pickedNum = new boolean[number.length];
        
        // 조합 : 3개를 뽑는 경우의 수 구하기
        // 뽑은 개수, 숫자배열, 뽑은숫자 저장할 배열
        pick(0,number,pickedNum,0);        
        
        return answer=ans;
    }
}