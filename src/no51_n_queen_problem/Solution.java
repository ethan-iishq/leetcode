package no51_n_queen_problem;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> ret = new ArrayList<List<String>>();
        
		List<Point> curList = new ArrayList<Point>(n);
		boolean finish = false;
		int x = 0, y = 0; 
		while(true){
			boolean findOnePlace = false;
		
			for(; x < n; x++){
				Point p = new Point(x, y);
				if(checkCanPlace(curList, p)){
					findOnePlace = true;
					curList.add(p);
					y++;
					break;
				}
			}
			
			
			if(curList.size() == n || !findOnePlace){
				//完成一个结果的搜索，那么继续搜索。
				if(curList.size() == n){
					System.out.println(curList.toString());
					printSearchedList(curList, n);
					List<String> ans = buildSearchedListToString(curList, n);
					ret.add(ans);
				}
				
				while(!curList.isEmpty()){
					Point lastPoint = curList.remove(curList.size() - 1);
					x = lastPoint.x + 1;
					y = lastPoint.y;
					if(x == n && y == 0){
						finish = true;
						break;
					}
					if(x < n){
						break;
					}
				}
			}else{
				y = curList.size();
				x = 0;
			}
			
			if(finish){
				break;
			}
			
		}
		
        return ret;
        
    }
    
    public void printSearchedList(List<Point> curList, int n){
    	for(int y = 0; y < n; ++y){
    		for(int x = 0; x < n; ++x){
    			Point p = curList.get(y);
    			if(p.x == x){
    				System.out.print("Q");
    			}else{
    				System.out.print(".");
    			}
        	}
    		System.out.println();
    		
		}
    	
    }
    
    public List<String> buildSearchedListToString(List<Point> curList, int n){
    	List<String> list = new ArrayList<String>(n);
    	for(int y = 0; y < n; ++y){
    		StringBuilder sb = new StringBuilder();
    		for(int x = 0; x < n; ++x){
    			Point p = curList.get(y);
    			if(p.x == x){
    				sb.append("Q");
    			}else{
    				sb.append(".");
    			}
        	}
    		list.add(sb.toString());
    		
		}
    	return list;
    }
    
	private boolean checkCanPlace(List<Point> curList, Point p){
		for(Point curPoint : curList){
			if(p.inLine(curPoint)){
				return false;
			}
		}
		return true;
	}
	
    public class Point{
        public int x;
        public int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
		public boolean inLine(Point p){
			if(this.x == p.x || this.y == p.y || this.abs( p.y - this.y) ==  this.abs(p.x - this.x)){
				return true;
			}
			return false;
		}
		private int abs(int num){
			if(num<0) return -num;
			else return num;
		}
		@Override
		public String toString(){
			return "("+x+","+y+")";
		}
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	
    	s.solveNQueens(5);
    	System.out.println("-------------------------------------------------");
    	s.solveNQueens(6);
    	System.out.println("-------------------------------------------------");
    	s.solveNQueens(7);
    }
}