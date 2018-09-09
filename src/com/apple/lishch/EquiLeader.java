package com.apple.lishch;

import java.util.Stack;

import org.junit.Test;

public class EquiLeader {
	public int solution(int[] A){
		int equiLeaderCnt = 0;
		int leader = leader(A);
		if(A.length < 2 || leader == Integer.MIN_VALUE){
			return equiLeaderCnt; 
		}
		
		int[] leaderCnt = new int[A.length];
		leaderCnt[0] = (A[0] == leader)? 1:0;
		for (int i = 1; i < A.length; i++) {
			leaderCnt[i] += leaderCnt[i-1]; 
			if(A[i] == leader){
				leaderCnt[i]++;
			}
		}
		
		for (int i = 0; i < A.length-1; i++) {
			if( leaderCnt[i] > (i+1)/2 && 
				(leaderCnt[A.length-1] - leaderCnt[i]) > (A.length-i -1)/2){
				equiLeaderCnt++;
			}
		}
		
		return equiLeaderCnt;
	}
	
	public int leader(int[] B){
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < B.length; i++) {
			if(stack.isEmpty() || stack.peek() == B[i]){
				stack.push(B[i]);
			}
			else if(stack.peek() != B[i]){
				stack.pop();
			}
		}
		
		if(stack.isEmpty()){
			return Integer.MAX_VALUE;
		}
		else {
			int cnt = 0;
			for (int i = 0; i < B.length; i++) {
				if(B[i] == stack.peek()){
					cnt++;
					if(cnt > B.length/2)return stack.peek();
				}
			}
			return Integer.MAX_VALUE;
		}
	}
	
	@Test
	public void test(){
		int[] A = new int[]{4,3,4,4,4,2};
		System.out.println(solution(A));
	}
	
}
