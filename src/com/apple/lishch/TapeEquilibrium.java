package com.apple.lishch;

public class TapeEquilibrium {
	
	public int solution(int[] A){
		int min = Integer.MAX_VALUE;		// minimal value
		int sumP1 = 0;						// sum of part2
		int sumP2 = 0;						// sum of part1

		// initial sumP1,sumP2,min
		sumP1 = A[0];
		for (int j = 1; j < A.length; j++) {
			sumP2 += A[j];
		}
		min = min < Math.abs(sumP1 - sumP2)? min:Math.abs(sumP1 - sumP2);
		
		// if the length is 2
		if (A.length == 2) {
			return min;
		}
		
		for (int i = 1; i < A.length - 1; i++) {
			sumP1 += A[i];
			sumP2 -= A[i];
			min = min < Math.abs(sumP1 - sumP2)? min:Math.abs(sumP1 - sumP2);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		int[] A = new int[]{-10, -20, -30, -40, 100};
		TapeEquilibrium tap01 = new TapeEquilibrium();
		System.out.println(tap01.solution(A));
	}
	
}
