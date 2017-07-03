package no54_spiral_matrix;

public class Solution {
	public static void printSpiralMatrix(int a[][], int m, int n){
		int top = 0;
		int bottom = m-1;
		int left = 0;
		int right = n-1;
		
		while(top <= bottom && left <= right){
			for(int i = left; i <= right; i++){
				System.out.print(a[top][i] + " ");
			}
			if((top += 1) > bottom) break;
			
			for(int i = top; i <= bottom; i++){
				System.out.print(a[i][right] + " ");
			}
			if((right -= 1) < left) break;
			
			for(int i = right; i >= left; i--){
				System.out.print(a[bottom][i] + " ");
			}
			if((bottom -= 1) < top) break;
			
			for(int i = bottom; i >= top; i--){
				System.out.print(a[i][left] + " ");
			}
			if((left += 1) > right) break;
		}
		 
		
	}
	public static void main(String[] args){
		int a[][] = {{1,2,3,4},{5,6,7,8}, {9, 10, 11, 12}};
		printSpiralMatrix(a, 3, 4);
		
	}
}
