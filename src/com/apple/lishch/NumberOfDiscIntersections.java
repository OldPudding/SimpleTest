package com.apple.lishch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NumberOfDiscIntersections {

	/**
	 * The maxmium intersction pair is n*(n-1)*2
	 * we just need to count the number of unintersction pairs,
	 * then we can get intersction pair = total - unintersction
	 * 
	 * the unintersction part should be and only can be the following case:
	 *     -when right border < left border
	 * as the facts that left border <= n-1 && right border >= 0 
	 * so we can srink the unintersction part case as:
	 *     -when 0 <= right border < left border <= n-1
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
    	long   total = (long)A.length*(A.length -1)/2;
    	
    	//disc number that right border is no greater then given index
    	int[] discNum = new int[A.length];
    	
    	for (int i = 0; i < A.length; i++) {
    		long rightBorder = (long)A[i] + i;
			if(rightBorder < A.length - 1){
				discNum[(int)rightBorder]++;
			}
		}
    	
    	for(int i = 1; i < discNum.length; i++){
    		discNum[i] += discNum[i-1];
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		int leftBorder = i - A[i];
			if(leftBorder > 0){
				total -= discNum[leftBorder - 1];
			}
		}
    	
    	if(total > 10_000_000){
    		return -1;
    	}
    	return (int)total;
    }
    
    @Test
    public void test(){
    	int[] A = new int[]{1,5,2,1,4,0};
    	System.out.println(solution(A));
    }
}
