package com.apple.lishch;

import org.junit.Test;

public class MaxSliceSum {
	/**
	 * Score 84,timeout
	 * @param A
	 * @return
	 */
	public int solution2(int[] A){
		int maxvalue = Integer.MIN_VALUE;
		int[] summary = new int[A.length];
		summary[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			summary[i] = summary[i-1] + A[i];
		}
		
		for (int i = 0; i < summary.length; i++) {
			for (int j = i; j < summary.length; j++) {
				int b = summary[j] - summary[i] + A[i];
				maxvalue = Math.max(maxvalue, b);
			}
		}
		
		return maxvalue;
	}

	/**
	 * Score 100
	 * @param A
	 * @return
	 */
	public static int solution(int[] A) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			max = A[i]>max?A[i]:max;
		}
		if(max<=0)
			return max;
		
		int maxSliceSum = 0;
		int currentSum = 0;	
		for (int i = 0; i < A.length; i++) {
			currentSum = (currentSum+A[i])>0?(currentSum+A[i]):0;
			maxSliceSum=currentSum>maxSliceSum?currentSum:maxSliceSum;
		}
		return maxSliceSum;
	}
	
	@Test
	public void test(){
		int[] A = new int[]{-1_000_000,-1_000_000,-1_000_000,-1_000_000,-1_000_000};
		System.out.println(solution(A));
	}
}
