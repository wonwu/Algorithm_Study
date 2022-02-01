package week3_BruteForceSearch;
/*
 * 완전탐색 PG_소수찾기 
 */
 
import java.util.*;

public class PG_findPrimeNum {
    static Map<Integer, Integer> hm = new HashMap<>();  // 소수 값 중복 체크
    
    public boolean check(int n){
        if(n <= 2) return false;
        
        for(int i = 2; i < n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    // 전체 numbers 배열, 뽑아야하는 개수, 뽑은 개수, 뽑은 수 저장 배열
    public void pick(int[] num, int k, int picked, int[] bucket){
        if(k == picked){
            int n = 0;
            for(int i = 0; i < k; i++){
                n += bucket[i] * Math.pow(10, i);
            }
            if(check(n)){
                hm.put(n, hm.getOrDefault(n,0));
            }
            return;
        }
        
        for(int i = picked; i <= k; i++){
            bucket[i] = num[i];
            pick(num, k-1, picked+1, bucket);
            bucket[i] = -1;
        }

    }
    
    public int solution(String numbers) {
        int answer = 0;
        int[] arr = new int[numbers.length()];  
        
        
        for(int i = 0; i < numbers.length(); i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        // 전체 numbers 개수, 뽑아야하는 개수, 뽑은 개수, 뽑은 수 저장 배열
        for(int i = 1; i <= arr.length; i++){
            int[] picked = new int[i];
            pick(arr, i, 0, picked);
        }
        
        return answer = hm.size();
    }
    
    public static void main(String[] args) {
		String numbers = "17";
		// String numbers = "011";
		
		PG_findPrimeNum fp = new PG_findPrimeNum();
		
		System.out.println(fp.solution(numbers));		

	}
}

