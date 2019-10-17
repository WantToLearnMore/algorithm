package com.priactice.algorithm.checkHome;

public class myAtoi {


    public int solurtion(String str){
        str=str.trim();//去掉2所有ascii码小于等于32 的字符
        if(str.equals(""))return 0;
        char []chars=str.toCharArray();
        long result=0;

        if(chars[0]=='-'||chars[0]=='+'){
            int i=1;
            result=getNum(chars,i);
            if(chars[0]=='-'){
                result=result*(-1);
            }
        }else {
            int i=0;
            result=getNum(chars,i);
        }

        if(result>=Integer.MAX_VALUE)result=Integer.MAX_VALUE;
        if(result<=Integer.MIN_VALUE)result=Integer.MIN_VALUE;
        return (int) result;
    }


    private long getNum(char[]chars,int index){
        int i=index;
        long result=0;
        while(i<chars.length&&chars[i]>='0'&&chars[i]<='9'){
            if(chars[i]>='0'&&chars[i]<='9'){
                result=result*10+Long.valueOf(String.valueOf(chars[i]));
            }
            if(result>=Integer.MAX_VALUE)break;
            i++;
        }
        return result;
    }

    public int solution2(String str){
        if(str==""){return 0;}
        //max(Math.min(int(*re.findall('^[\+\-]?\d+', s.lstrip())), 2**31 - 1), -2**31)
        // python中的简便实现
        return 0;
    }

    public static void main(String []args){
        String s="9223372036854775808";
        myAtoi m=new myAtoi();
        System.out.println(m.solurtion(s));
    }

}
