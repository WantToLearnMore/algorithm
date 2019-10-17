package com.priactice.algorithm.checkHome;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LengthOfLongestSubstring {
    public int solution(String s){
        if ("".equals(s)) {
        return 0;
        }
        int length=1;
        int currentLength=1;
        int p=0;
        char []chars=s.toCharArray();
        String currentString=String.valueOf(chars[0]);
        for(int i=1;i<chars.length;){
            if (currentString.contains(String.valueOf(chars[i]))) {
                currentLength=0;
                currentString="";
                int n=s.indexOf(chars[i]);
                s=s.substring(n+1,s.length());
                p=n+p+1;
                i=p;
            }else {
                currentLength=currentLength+1;
                currentString=currentString+String.valueOf(chars[i]);
                i++;
            }
            length=currentLength>length?currentLength:length;
        }
        return length;
    }


    //
    public  int solution2(String s){
        if ("".equals(s)) {
            return 0;
        }
        int length=1;
        char []chars=s.toCharArray();
        String currentString=new String();
        for(int i=0;i<chars.length;i++){
            if (currentString.contains(String.valueOf(chars[i]))) {
                length=currentString.length()>length?currentString.length():length;
                int n=currentString.indexOf(chars[i]);
                currentString=currentString.substring(n+1,currentString.length());
                currentString=currentString+String.valueOf(chars[i]);
            }else {
                currentString=currentString+String.valueOf(chars[i]);
            }
        }
        return currentString.length()>length?currentString.length():length;
    }


    /*
    * 双指针法
    * 如果S[j]在[i，j)范围内有与J'重复的字符，
    * 则不需要逐渐增加i，可以直接跳过[i，j']
    * 范围内的所有元素，并将i变为j'+i;
    * **/
    public int solution3(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /*
    * 遍历字符串，每次以 i 值记录，不回溯 i 值，
    * 用flag记录遍历过程找到的重复的字符的位置。
    * 如果遇到重复字符，i-flag 即为子串长度，此
    * 时flag重新定位到子串中重复字符的位置，i
    * 继续往后遍历。这里length跟result记录长度。
    * **/
    public int solution4(String s){
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }
   public static void main(String []args){
        String s="          abcddddddd";
        LengthOfLongestSubstring lengthOfLongestSubstring=new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.solution2(s));




   }
}
