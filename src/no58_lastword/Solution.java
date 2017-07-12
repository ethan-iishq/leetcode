package no58_lastword;
public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
    	while(i >= 0 && s.charAt(i) == ' '){
    		--i;
    	}
        if(i < 0) return 0;
        int j = i-1;
        while(j >= 0 && s.charAt(j) != ' '){
    		--j;
    	}
        return i-j;
    }
    public static void main(String[] args){
    	Solution sn = new Solution();
    	String[] strs = {"hellow", "hellow ", " hellow", " hellow ", " hellow ", "", "  "};
    	for(String s : strs){
    		System.out.println(s + " last word len:"+ sn.lengthOfLastWord(s));
    	}
    }
}