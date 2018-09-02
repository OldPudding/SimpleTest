package com.apple.lishch;

import org.junit.Test;

public class TenisGame {
    public int solution(int P, int C) {
        if(P < 2){
        	return 0;
        }
        
        return C*2 < P? C:P/2;
    }
    
    @Test
    public void testF(){
    	System.out.println(solution(5, 3));
    }
}
