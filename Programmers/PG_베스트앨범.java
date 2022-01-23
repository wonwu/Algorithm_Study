package week1_Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * [핵심]
 * 1) map.getOrDefault(p,0)  
 *		:HashMap hm에 p라는 키의 값 반환, 없으면 0 반환 (동명이인 카운트위해) 해시맵에 값으로 int형 배열 저장
 * 2) 정렬
 * Map.Entry 리스트 생성 후 Comparator 사용해 내림차순 정렬 (해시맵은 순서가 없으므로 정렬 x)
 * Comparator 구현 클래스 없이, Comparator 인스턴스 생성과 동시에 compare() 메서드를 오버라이드
 *
 * 3) compareTo함수 (숫자,문자)
 * 		기준값.compareTo(비교값);
 * 		숫자 비교에서는 
 * 		- 기준값 == 비교값: 0 반환
 * 		- 기준값 > 비교값 : 1 반환
 * 		- 기준값 < 비교값 : -1 반환
 * 
 * [알고리즘]
 * 1. 각 장를별 재생횟수 저장할 해시맵 map
 * 2. Map.Entry 리스트 생성 후, Comparator 사용해 장르별 재생횟수 기준으로 내림차순 정렬 (방법1) 
 * 3. 각 장르별 재생횟수가 가장 많은 두곡 담을 리스트 rslt 만들고
 * 4. topGenre.size()만큼 반복문 돌려 장르별 play 횟수가 가장 큰 2 노래의 인덱스 찾기
 		장르 당 하나의 노래만 있는 경우 조심
 * 5. 리스트 rslt를 배열 answer로 바꿔서 반환
 * 
 */
public class BestAlbum {
	
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 각 장를별 재생횟수 저장할 해시맵
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        /************ 각 장르별 재생횟수 내림차순 정렬하는 방법1 ************/
        // Map.Entry 리스트 생성
        ArrayList<Map.Entry<String, Integer>> topGenre = new ArrayList<>(map.entrySet());

        Collections.sort(topGenre, new Comparator<Map.Entry<String,Integer>>(){
           @Override
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());	// 내림차순
            }
        });
        
        // 방법1로 정렬된 결과 출력 (장르: 재생횟수)
//	     for(Map.Entry<String, Integer> e : topGenre) {
//	    	 System.out.println(e.getKey() + ":" + e.getValue());
//	     }
        
        // 각 장르별 재생횟수가 가장 많은 두곡 담을 리스트
        ArrayList<Integer> rslt = new ArrayList<>();
        
        for(Map.Entry<String, Integer> e : topGenre) {
        	String g = e.getKey();        	
        	
        	// 해당 장르에서 play 횟수가 가장 큰 노래의 인덱스
        	int max = 0;
        	int idx1 = -1;
        	for(int j = 0; j < genres.length; j++) {
        		if(g.equals(genres[j]) && plays[j] > max) {
        			max = plays[j];
        			idx1 = j;
        		}
        	}
        	
        	// 해당 장르에서 play 횟수가 두번째로 큰 노래의 인덱스
        	max = 0;
        	int idx2 = -1;           	
        	for(int j = 0; j < genres.length; j++) {
        		if(g.equals(genres[j]) && plays[j] > max && j != idx1) {
        			max = plays[j];
        			idx2 = j;
        		}
        	} 
        	
        	rslt.add(idx1);
        	// 장르 당 하나의 노래만 있는 경우
        	if(idx2 >= 0) rslt.add(idx2);
        	
        }
        
        // 리스트 rslt를 배열 answer로 변환
        answer = new int[rslt.size()];
        for(int i = 0; i < rslt.size(); i++) {
        	answer[i] = rslt.get(i);
        }
        
		return answer;        
    }   
    
	public static void main(String[] args) {	
		    String[] genres = {"classic","pop","classic","classic","pop"};
        int[] plays = {500,600,150,800,2500};
       
        BestAlbum b = new BestAlbum();
        
        System.out.println(Arrays.toString(b.solution(genres, plays)));
	}

}
