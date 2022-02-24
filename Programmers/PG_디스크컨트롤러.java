import java.util.PriorityQueue;
import java.util.Comparator;
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
    1) waitingQ : reqTime (요청시간) 빠른 적은 것
    2) pq : '이전 작업의 끝난시간'에 걸쳐있거나 '이전'에 있는 작업 선택
        - 두개 이상 걸쳐있으면, sTime (소요시간) 적은 것
        - 걸쳐있지 않으면, 다음 요청시간의 작업 선택

*/

class Solution {
    class Job {
        int reqTime; // 요청되는 시점
        int sTime; //  소요시간

        Job(int reqTime, int sTime){
            this.reqTime = reqTime;
            this.sTime = sTime;
        }
    
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청시간reqTime 빠른 순으로 정렬되는 우선순위 큐 : waitingQ
        PriorityQueue<Job> waitingQ = new PriorityQueue(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.reqTime - j2.reqTime;
            }
        });     
      
        for(int[] j : jobs){
            waitingQ.offer(new Job(j[0], j[1]));
        }
        
        // 작업 소요시간sTime이 적은 순으로 정렬되는 우선순위 큐 :pq
        PriorityQueue<Job> pq = new PriorityQueue(new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){
                return j1.sTime - j2.sTime;
            }
        });
        
        int cnt = 0; // 처리한 작업 수
        int sum = 0; // 처리한 총 소요시간 합
        int now = 0; // 현재 시간 (1ms 단위로 흐름)
        
        while(cnt < jobs.length){
            
            // 요청시간reqTime이 된 작업들 pq에 넣기 = 지금 시점에서 실행할 수 있는 작업들
            // '현재시간(이전 작업의 끝난시간)'에 걸쳐있거나 이전에 있는 작업들 선택
            while(!waitingQ.isEmpty() && now >= waitingQ.peek().reqTime){
                pq.offer(waitingQ.poll());
            }
            
            // 각 시점에 실행할 수 있는 작업 중, 가장 빨리 끝나는 작업 선택
            if(!pq.isEmpty()){
                Job j = pq.poll();
                sum += j.sTime + (now - j.reqTime);     // 소요시간 + (현재시점 - 요청시간)
                now += j.sTime;                         // 현재 시점 갱신 : 해당 작업의 소요시간 더하기
                cnt++;
            }
            else{
                // 현재 실행할 수 있는 작업 없으므로 +1ms
                now++;
            }
        }
                
        return answer = sum / cnt;
    }
}

