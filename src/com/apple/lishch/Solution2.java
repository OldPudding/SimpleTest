package com.apple.lishch;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
	public int heheda;
	
    public int solution(int[] A) {
    	int max = 0;
        if(A.length <= 1){
        	return -1;
        }
        
        int[] sortB = A.clone();
        Arrays.sort(sortB);
        
        Map<Integer, Integer> sortMap01 = new HashMap<Integer, Integer>();
        for (int i = 0; i < sortB.length; i++) {
			if(!sortMap01.containsKey(sortB[i])){
				sortMap01.put(sortB[i], i);
			}
		}
        
        for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				if(A[i] != A[j]){
					//if there is a value lies between A[i] and A[j]
					if(Math.abs(sortMap01.get(A[i]) - sortMap01.get(A[i])) == 1){
						max = max > Math.abs(i - j)? max:Math.abs(i - j);
					}
					else {
						int index = i > j? i-1:j-1;
						if(A[index] == A[i] || A[index] == A[j]){
							max = max > Math.abs(i - j)? max:Math.abs(i - j);
						}
					}
				}
			}
		}
        
        return max;
    }
    
	public static void main(String[] args) {
		Solution2 solu = new Solution2();
		int[] A = new int[]{};
		System.out.println("adfasdf");
	}
}
