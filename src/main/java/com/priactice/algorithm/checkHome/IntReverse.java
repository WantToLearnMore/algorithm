package com.priactice.algorithm.checkHome;

import java.util.ArrayList;
import java.util.List;

public class IntReverse {
    public int solution(int x){

        List<Integer>num=new ArrayList<>();
        int sign=10;
        while(x!=0){
            num.add(x%sign);
            x=x/sign;
        }
        int len=num.size();
        int reslt=num.get(len-1);
        for (int i=0;i<=len-2;i++){
            int m=num.get(len-2-i);
            if ((reslt>Integer.MAX_VALUE/10)||(reslt==Integer.MAX_VALUE/10&&m!=0)){return 0;}
            if((reslt<Integer.MIN_VALUE/10)||(reslt==Integer.MIN_VALUE/10&&m!=0))
            reslt=reslt+m*sign;
            sign=sign*10;
        }

        return  reslt;
    }

    public int soulution2(int x){
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;
        return (int) y;

    }


    public static void main(String []args){
        IntReverse intReverse=new IntReverse();
        int x=1534236469;
        System.out.println(intReverse.solution(x));
    }
}
