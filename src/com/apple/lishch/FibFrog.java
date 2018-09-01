package com.apple.lishch;

import java.util.*;
import java.util.ArrayList;

import org.junit.Test;

public class FibFrog {
	class Track{
		public int position;
		public int jumpTimes;
		public Track(int pos, int jumps) {
			position = pos;
			jumpTimes = jumps;
		}
	}
	
	public int solution(int[] A){
		//get the fibonacci number list up to N+1
    	List<Integer> fibo = fibonacciUpto(A.length + 1);
    	//visit flag
    	boolean[] visitFlg = new boolean[A.length];
    	//jump path
    	List<Track> jumpRoute = new ArrayList<Track>();
    	jumpRoute.add(new Track(-1, 0));
    	
    	while(jumpRoute.size() > 0){
    		int   minJumps    = jumpRoute.get(0).jumpTimes;
    		int   currentPos  = jumpRoute.get(0).position;
    		jumpRoute.remove(0);
    		
    		for (int fiboLength : fibo) {
    			if(currentPos + fiboLength > A.length){
    				break;
    			}
    			if(currentPos + fiboLength == A.length){
    				// find the best jump
    				return minJumps + 1;
    			}
    			else{
    				if(A[currentPos + fiboLength] == 1 && 
    				   !visitFlg[currentPos + fiboLength]){
    					visitFlg[currentPos+ fiboLength] = true;
    					jumpRoute.add(new Track(currentPos + fiboLength, minJumps + 1));
    				}
    			}				
			}
    	}
    	
    	return -1;
    }
    
	/**
	 * calculate all the fibonacci numbers less then the given maximum value 
	 * @param max
	 * @return
	 */
    public List<Integer> fibonacciUpto(int max) {
    	List<Integer> fiboNumList = new ArrayList<Integer>();
    	fiboNumList.add(0);
    	fiboNumList.add(1);
    	int i = 2;
    	do{
    		fiboNumList.add(fiboNumList.get(i-1) + fiboNumList.get(i-2));
    	}
    	while(fiboNumList.get(i++) < max);
    	fiboNumList.remove(0);
    	fiboNumList.remove(1);
    	return fiboNumList;
	}
    
    @Test
    public void testMethod(){
    	System.out.println(Arrays.toString(fibonacciUpto(14).toArray()));
    }
}
