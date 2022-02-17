import java.util.PriorityQueue;
/*
우선순위큐 : 우선순위가 가장 높은 데이터를 가장 먼저 삭제하는 자료구조

최소힙 min-heap 
PriorityQueue<Integer> p = new PriorityQueue<>();
최대힙 max-heap
PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

섞은 스코빌 지수 = 가장 낮은 지수 + (두번째로 낮은 지수 * 2)
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 
*/
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 최소힙 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K){
            if(pq.size() < 2) return -1;
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + s2*2);
        }
        
        return answer = scoville.length - pq.size();
    }
}
