package com.apple.lishch;

import java.awt.List;
import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import javax.print.attribute.Size2DSyntax;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.xml.ws.AsyncHandler;

import org.omg.PortableServer.ThreadPolicyOperations;

class Solution {
	/**
	 * solution2
	 * @param A
	 * @return
	 */
	public int solution2(int[] A){
		int result = 0;
		int sum1 = 0;
		int sum2 = 0;
		int i    = 0;
		for(i = 0; i < A.length; i++){
			sum1+=A[i];
			sum2+=i+1;
		}
		sum2+=i+1;
		return sum2 - sum1;
	}
	
	/**
	 * solution
	 * @param X
	 * @param A
	 * @return
	 */
	public int solution3(int X, int[] A){
		boolean arrayX[] = new boolean[X];
		int total = 0;
		
		for(int i = 0; i < A.length; i++){
			if(arrayX[A[i]-1] == false){
				arrayX[A[i]-1] = true;
				total ++;
			}
			
			// when position X show out
			if(arrayX[X-1] && total >= X){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * A permutation is a sequence check
	 * @param A
	 * @return 1:yes 0:no
	 */
	public int solution4(int[] A){
		boolean arrayFlg[] = new boolean[A.length + 1];
		if(A.length <= 1){
			if(A[0] != 1){
				return 0;
			}
		}
		
		int appreaTimes = 0;
		for(int i = 0; i< A.length; i++){
			if(A[i] > A.length){
				return 0;
			}
			else if(arrayFlg[A[i]] == false){
				arrayFlg[A[i]] = true;
				appreaTimes++;
			}
		}
		
		if(appreaTimes == A.length){
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * Find the smallest positive integer that does not occur in a given sequence
	 * @param A
	 * @return 
	 * the smallest positive integer (greater than 0) 
	 */
	public int solution5(int[] A){
		if(A.length == 1){
			return A[0]>0?A[0]+1:1;
		}
		boolean arrFlg[] = new boolean[1000001];
		for(int i = 0; i < A.length; i++){
			if(A[i] > 0 && A[i] < arrFlg.length && arrFlg[A[i]] == false){
				arrFlg[A[i]] = true;
			}
		}
		
		int j = 1;
		for(j = 1; j < arrFlg.length; j++){
			if(arrFlg[j] == false){
				return j;
			}
		}
		return j + 1;
		
	}
	
	/**
	 * MaxCounters
	 * @param N
	 * @param A
	 * @return 
	 * 	sequence of integers representing the values of the counters
	 */
	public int[] solution6(int N, int[] A){
		int solution[] = new int[N];
		int maxCounter = 0;
		int total = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] <= N){
                if(solution[A[i] - 1] >= total)
                {
                	solution[A[i] - 1] += 1;  
                }
                else
                {
                	solution[A[i] - 1] = total +1;
                }
                
                if(maxCounter < solution[A[i] - 1])  
                {  
                    maxCounter = solution[A[i] - 1];  
                }
			}
			else{
				total = maxCounter;
			}
		}
		
		for (int i = 0; i < solution.length; i++) {
			if(solution[i] < total){
				solution[i] = total;
			}
		}
		
		return solution;
	}
	
	public int solution7(int A, int B, int K){
		int result = 0;
		result = B/K - A/K;
		
		if(A%K != 0){
			return result;
		}
		
		return ++result;
	}
	
	public int solution8(int[] A){
		int result = 0;
		int totalOnes = 0;
		for (int i = A.length-1; i >= 0; i--) {
			if(A[i] == 1){
				totalOnes++;
			}
			else{
				result += totalOnes;
			}
			
			if(result > 1000000000){
				return -1;
			}
		}
		
		return result;
	}
	
	public int solution9(int[] A){
		int index = 0;
		BigDecimal minDev = new BigDecimal(0);
		for (int i = 0; i < A.length-1; i++) {
			
		}
		return index;
	}
	
	public int[] solution10(String S, int[] P, int[] Q){
		int[] paraS = new int[S.toCharArray().length];
		int[] result = new int[Q.length];
		
		int j = 0;
		for (char i : S.toCharArray()) {
			switch (i) {
			case 'A':
				paraS[j++] = 1;
				break;
			case 'C':
				paraS[j++] = 2;
				break;
			case 'G':
				paraS[j++] = 3;
				break;
			case 'T':
				paraS[j++] = 4;
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < P.length; i++) {
			int startP = P[i];
			int endP   = Q[i];
			int min = paraS[startP];
			for (int k = startP; k <= endP; k++) {
				min = min < paraS[k]? min:paraS[k];
			}
			result[i] = min;
		}
	
		return result;
	}

	public int solution11(int N) {
		int max = 0;
		int length = 0;
		char[] paraN = Integer.toBinaryString(N).toCharArray();
		for(int i = 0; i < paraN.length; i++){
			if(paraN[i] == '1'){
				max = max > length? max:length;
				length = 0;
			}
			else{
				length++;
			}
		}
		return max;
	}
	/**
	 * demo task
	 * @param A
	 * @return
	 */
    public int solution12(int[] A) {
        boolean[] appreFlg = new boolean[A.length+1];
        for (int i = 0; i < A.length; i++) {
			if(A[i] >= 0 && A[i] <= A.length ){
				appreFlg[A[i]] = true;
			}
		}

        for (int i = 1; i < appreFlg.length; i++) {
			if(appreFlg[i] == false){
				return i;
			}
		}
        return appreFlg.length;
    }
	
    public int[] solution13(int[] A, int K) {
        int[] B = new int[A.length];
    	int offset = K%A.length;
    	int index = 0;
    	
        for (int i = 0; i < B.length; i++) {
        	index = (i-offset+A.length)%A.length;
			B[i] = A[index];
		}
        return B;
    }

    /**
     * find the dominator of array A
     * @param A
     * @return
     */
    public int solution14(int[] A) {
    	if(A.length == 0){
    		return -1;
    	}
    	
    	Map<Integer, Integer> map01 = new HashMap<Integer,Integer>();
    	map01.put(A[0], 0);
    	for (int i = 0; i < A.length; i++) {
			if(map01.containsKey(A[i])){
				int cnt = map01.get(A[i]);
				map01.replace(A[i], ++cnt);
				//find the leader
				if(cnt > A.length/2){
					return i;
				}
			}
			else{
				map01.put(A[i], 1);
			}
			
			// the extrem case
			if(map01.get(A[i]) > A.length/2){
				return i;
			}
		}
    	
        return -1;
    }
    
    public int solution(int[] A, int[] B) {
    	int total = 0;
    	boolean[] dieFlg = new boolean[B.length];
    	Stack<Integer> badFish = new Stack<Integer>();
    	Stack<Integer> badFishSize = new Stack<Integer>();
    	
    	for (int i = 0; i < B.length; i++) {
			if(B[i] == 0 && badFish.isEmpty()){
				continue;
			}
			else if(B[i] == 0 && !badFish.isEmpty()){
				while(!badFish.isEmpty()){
					int badSize = badFishSize.peek();
					// the bad eat the good
					if(A[i] < badSize){
						dieFlg[i] = true;
						break;
					}
					// the good eat the bad
					else{
						dieFlg[badFish.pop()] = true;
						badFishSize.pop();
					}
				}
			}
			else{
				badFish.push(i);
				badFishSize.push(A[i]);
			}
		}
    	
    	for (boolean c : dieFlg) {
			if(!c){
				total++;
			}
		}
    	return total;
    }
    
	public static void main(String[] args) {
		Solution solu = new Solution();
		int[] A = new int[]{4,3,2,1,5};
		int[] B = new int[]{1,1,0,0,0};
		System.out.println(solu.solution(A,B));
	}
}
