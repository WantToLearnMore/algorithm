package com.priactice.algorithm.checkHome;

import java.util.*;

public class ZConvert {
    public String convert(String s,int numRows){
        if("".equals(s)||s.length()==1||numRows==1){
            return s;
        }
        Map map=new HashMap();
        String result="";
        char[] chars= s.toCharArray();
        int column=0;
        List<Integer> list= new ArrayList<>();
        int num=s.length()/(2*numRows-2);
        int remainder=s.length()-num*(2*numRows-2);
        int columns=num*(numRows-2+1);
        if(num==0){
            columns=s.length()-numRows+1;
        }
        for(int i=0;i<num*(2*numRows-2);){
            column=column+1;
            for(int j=0;j<numRows;j++){
                char str=chars[j+i];
                int coordinate=(j+1)*getNum(columns)+column;
                map.put(coordinate,str);
                list.add(coordinate);
            }
            for(int n=0;n<numRows-2;n++){
                column=column+1;
                int coordinate=(numRows-n-1)*getNum(columns)+column;
                map.put(coordinate,chars[i+n+numRows]);
                list.add(coordinate);
            }
            i=i+2*numRows-2;
        }

        if(remainder>0){
            column=column+1;
            if(remainder<=numRows){
                int start=num*(2*numRows-2);
                for(int i=0;i<remainder;i++){
                    int coordinate=(i+1)*getNum(columns)+column;
                    map.put(coordinate,chars[start+i]);
                    list.add(coordinate);
                }
            }else {
                int start=num*(2*numRows-2);
                for(int i=0;i<numRows;i++){
                    int coordinate=(i+1)*getNum(columns)+column;
                    map.put(coordinate,chars[start+i]);
                    list.add(coordinate);
                }
                for(int j=0;j<remainder-numRows;j++){
                    column=column+1;
                    int coordinate=(numRows-j-1)*getNum(columns)+column;
                    map.put(coordinate,chars[start+numRows+j]);
                    list.add(coordinate);
                }
            }

        }

        Collections.sort(list);
        for(Integer i:list){
            result=result+String.valueOf(map.get(i));
        }
        return result;
    }


    private int getNum(int num){
        int result=100;
        while (num>=10){
            num=num/10;
            result=result*10;
        }
        return result;
    }



    /*
    *思路：找出每行元素索引的规律
    按照与逐行读取 Z 字形图案相同的顺序访问字符串。

   算法
   首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
   对于所有整数 kk，

   行 0 中的字符位于索引 k(2⋅numRows−2) 处;
   行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1 处;
   内部的行 i 中的字符位于索引 k(2⋅numRows−2)+i 以及 (k+1)(2⋅numRows−2)−i 处;
   **/
    public String solution2(String s,int numRows){
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    /*
    *思路：通过从左向右迭代字符串。
    *算法：使用min（numRows，len(s)）列表来表示Z字形图案中的非空行
    * 从左到右迭代s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
    * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会改变。
    * */
    public String solution(String s,int numRows){
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;//反转goingDown
            /*
            当goingDown为true时，curRow=curRow+1；
            当goingDown为false时，curRow=curRow-1；
            **/
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static  void main(String []args){

        ZConvert zConvert=new ZConvert();
        String str="PAYPALISHIRING";
        String string=zConvert.convert(str,3);
        String s=string.trim();
        System.out.println(s);

        String test="qvxryrwbmbmepfpzeyvkrzajzest";
        System.out.println(test.length());
        string=zConvert.convert(test,9);
        s=string.trim();
        System.out.println(s);
    }
}
