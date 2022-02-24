import java.util.PriorityQueue;

/*
PG_디스크컨트롤러

[핵심]
* 배열이나 다른 구조체를 PQ에 담기 위해서, 어떤 값을 기준으로 우선순위 정할지 직접 정해야함
    방법1) 새 클래스 정의 후, Comparable 상속 받아 정렬 기준 직접 정의 -> compareTo 메서드 Override
    방법2) PQ 정의할 때, Comparator 통해 compare함수 오버리이딩

* SJF(shortest job first)

[알고리즘]
Job Scheduing문제
작업들의 평균 걸린 시간(ATT)이 가장 작아지는 스케일링 알고리즘은 "SJF(shortest job first)"
'각 시점'에 실행할 수 있는 작업 중 '가장 빨리 끝나는' 작업 선택!

큐 2개 사용
    1) waitingQ : requestTime (요청시간) 빠른 적은 것
    2) pq : '이전 작업의 끝난시간'에 걸쳐있거나 이후에 있는 작업 선택
        - 두개 이상 걸쳐있으면, requiredTime (소요시간) 적은 것
        - 걸쳐있지 않으면, 다음 요청시간의 작업 선택

*/

