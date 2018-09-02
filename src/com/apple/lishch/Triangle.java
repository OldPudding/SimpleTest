package com.apple.lishch;

import java.util.Arrays;

import org.junit.Test;

public class Triangle {
    public int solution(int[] A) {
    	if(A.length < 3){
    		return 0;
    	}
    	
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
			if((long)A[i-2] + (long)A[i-1] > (long)A[i]){
				return 1;
			}
		}
        
        return 0;
    }
    
    @Test
    public  void testM() {
    	int[] A = new int[]{10,50,5,1};
		System.out.println(solution(A));
	}
}
