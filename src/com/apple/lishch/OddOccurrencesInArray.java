package com.apple.lishch;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
			if(!map.containsKey(A[i])){
				map.put(A[i], i);
			}
			else {
				map.remove(A[i]);
			}
		}
        
        for (int key:map.keySet()) {
			return key;
		}
        return -1;
    }
}
