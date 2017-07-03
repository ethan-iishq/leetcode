package no53_maxmum_subarray;

public class Solution {
	public static  int maximunSubarray(int a[]){
		int n = a.length;
		int max = a[0], sum = a[0];
		for(int i = 1; i < n; ++i){
			if(sum < 0){
				sum = sum > a[i] ? sum : a[i];
			}else{
				if((sum += a[i]) < 0){
					sum = 0;
				}
			}
			max = max > sum ? max : sum;
		
		}
		return max;
	}
	
	public static void main(String[] args){
		int a[] = {-7, -2, -1};
		int b[] = {-1, 1, 3, -2, 5, -3};
		
		System.out.println(maximunSubarray(a));
		System.out.println(maximunSubarray(b));
	}
}
