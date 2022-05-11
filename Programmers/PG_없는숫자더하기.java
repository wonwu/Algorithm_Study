/*
PG_없는 숫자 더하기

[ 배열에 특정값(value)이 포함되었는지 여부 ]

방법1) 
Arrays.asList(array).contains(value);
true/false 반환

방법2)
value가 숫자 (java8 이상)
IntStream.of(array).anyMatch(x -> x == value);
true/false 반환

*value가 문자열
Arrays.stream(array).anyMatch("value"::equals);
true/false 반환
*/

/*
for문 안 조건문에
IntStream.of(n).anyMatch(x -> x == v) 작성 시 컴파일 오류
"local variables referenced from a lambda expression must be final or effectively final"
    - 람다는 참조하는 지역변수에 대한 복사값을 가지고 동작하기 때문
    - 복사본에서 값이 바뀌어 버리면(= final or effective final이 아니면 = 최종값과 복사값이 다르면) 
        오류를 발생할 수 있어 컴파일 단계에서 막는 것
해결 : 함수로 따로 빼기 
*/

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i = 1; i <= 9; i++){
            if(!contains(numbers,i)){
                answer += i;
            } 
        }
        // 다른 풀이 : 0-9까지 합 - numbers배열 합 
        // return 45-Arrays.stream(numbers).sum();
        return answer;
    }
    
    public boolean contains(int[] n, int v){
        return IntStream.of(n).anyMatch(x -> x == v);
    }
}