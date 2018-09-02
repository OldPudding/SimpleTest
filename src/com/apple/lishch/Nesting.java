package com.apple.lishch;

import java.util.Stack;

import org.junit.Test;

public class Nesting {
	public int solution(String S){
		Stack<Character> nest = new Stack<Character>();
		for (char word : S.toCharArray()) {
			switch (word) {
			case '(':
				nest.push('(');
				break;
			case '[':
				nest.push('[');
				break;
			case '{':
				nest.push('{');
				break;
			//-------------------------------------
			case ')':
				if(nest.isEmpty())return 0;
				if(nest.pop() != '(')return 0;
				break;
			case ']':
				if(nest.isEmpty())return 0;
				if(nest.pop() != '[')return 0;
				break;
			case '}':
				if(nest.isEmpty())return 0;
				if(nest.pop() != '{')return 0;
				break;
			}
		}
		
		if(nest.isEmpty()){
			return 1;
		}
		return 0;
	}
	
	@Test
	public void test(){
		String S = "([)()]";
		System.out.println(solution(S));
	}
}
