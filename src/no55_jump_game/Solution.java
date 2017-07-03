package no55_jump_game;

public class Solution {
	public static boolean jumpRet(int a[]){
		int n = a.length;
		int index = 0;
		while(index < n-1 && a[index] > 0){
			index += a[index];
		}
		if(index == n-1) return true;
		else return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2, 3, 1, 1, 1, 4};
		int b[] = {3, 2, 1, 0, 4};
		
		System.out.println(jumpRet(a));
		System.out.println(jumpRet(b));
	}

}
