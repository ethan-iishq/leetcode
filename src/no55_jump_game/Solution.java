package no55_jump_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static int[] curret;
    public static boolean canJump(int[] nums) {
    	curret = new int[nums.length];
        return recuJump(nums, 0);
    }
    public static boolean recuJump(int[] nums, int start_index){
        if(start_index >= nums.length-1) return true;
        
        if(nums[start_index] == 0){
            return false;
        }else{
            boolean ret = false;
            for(int i = nums[start_index]; i > 0; i--){
            	if(curret[start_index+i] != 0){
            		ret = curret[start_index+i] > 0 ? true : false;
            	}else{
            		ret = recuJump(nums, start_index+i);
            		if(ret) curret[start_index+i] = 1;
            		else curret[start_index+i] = -1;
            	}
                
                if(ret) return true;
            }
        }
        return false;
    }
    
    public static boolean canJump2(int[] nums) {
    	int[] curret = new int[nums.length];
    	Stack<Integer> s = new Stack<Integer>();
        int index = 0, j = 0;
        s.push(index);
        while(true){
        	
    		for(; j < nums.length && nums[j] > 0; j++){
        		j += nums[j];
        		s.push(j);
        	}
    		if(j >= nums.length - 1) return true;
    		while(s.peek() >= s.pop() - 1){
    			s.pop();
    		}
    		
    		
        }
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2, 3, 1, 1, 1, 4};
		int b[] = {3, 2, 1, 0, 4};
		int c[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		System.out.println(canJump(a));
		System.out.println(canJump(b));
		System.out.println(canJump(c));
	}
}