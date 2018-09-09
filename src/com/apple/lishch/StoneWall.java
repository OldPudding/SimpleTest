package com.apple.lishch;

import java.util.Stack;

import org.junit.Test;

public class StoneWall {
	public int solution(int[] H){
		int totalStone = 0;
		int currentH   = 0;
		Stack<Integer> walls = new Stack<Integer>();
		
		for (int i = 0; i < H.length; i++) {
			if (currentH > H[i]) {
				while (currentH > H[i]) {
					currentH -= walls.pop();
					totalStone++;
				}
				if (H[i] - currentH > 0) {
					walls.push(H[i] - currentH);
				}
			} else if (currentH < H[i]) {
				walls.push(H[i] - currentH);
			}

			currentH = H[i];
		}
		
		while (!walls.isEmpty()) {
			walls.pop();
			totalStone++;
		}
		
		return totalStone;
	}
	
	@Test
	public void test(){
		int[] H = new int[]{8,8,5,7,9,8,7,4,8};	
		System.out.println(solution(H));
	}
}
