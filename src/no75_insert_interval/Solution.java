package no75_insert_interval;

import java.util.ArrayList;
import java.util.List;

class Interval {
     int start;
      int end;
     Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
 
public class Solution {
	private boolean canMerge(Interval a, Interval b){
        if(a.end >= b.start ) return true;
        else return false;
    }
    private Interval mergeTwo(Interval a, Interval b){
        return new Interval(a.start, Math.max(b.end, a.end));
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval>  ret = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            ret.add(newInterval);
        }else{
            int i = 0;
            for(; i < intervals.size(); i++){
                if(intervals.get(i).start < newInterval.start){
                	ret.add(intervals.get(i));
                }else{
                    break;
                }
            }
            --i;
            
            System.out.println("search start index:" + i);  
            Interval s = i< 0? newInterval:intervals.get(i);
            Interval cur;
            if(i >= 0){
            	ret.remove(ret.size()-1);
            	cur = newInterval;
            	if(canMerge(s, cur)){
            		s = mergeTwo(s, cur);
            	}else{
            		ret.add(s);
            		s = cur;
            	}
            	
            	
            }
            for(int j = i+1; j<intervals.size(); j++){
                cur = intervals.get(j);
                if(canMerge(s, cur)){
                    s = mergeTwo(s, cur);
                }else{
                    ret.add(s);
                    s = cur;
                }
            }
            ret.add(s);
            
        }
        return ret;
    }
    public static void main(String[] args){
    	//[[1,2],[3,5],[6,7],[8,10],[12,16]]
    	//[4,9]
    	  Solution s = new Solution();
    	  Interval  il1 = new Interval(1,2);
    	  Interval  il2 = new Interval(3,5);
    	  Interval  il3 = new Interval(6,7);
    	  Interval  il4 = new Interval(8,10);
    	  Interval  il5 = new Interval(12,16);
    	  Interval  il6 = new Interval(4,9);
    	  List<Interval> l = new ArrayList<Interval>();
    	  l.add(il1); l.add(il2);
    	  l.add(il3); l.add(il4);
    	  l.add(il5); //l.add(il2);
    	  for(Interval il : l){
    		  System.out.println("["+il.start+","+il.end+"] ");
    	  }
    	  List<Interval> ret = s.insert(l, il6);
    	  for(Interval il : ret){
    		  System.out.println("["+il.start+","+il.end+"] ");
    	  }
    	  
    }

}