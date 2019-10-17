package com.priactice.algorithm.checkHome;

public class IsPalindrome {

    /*
    * 思路：先将改整数反转，在与原整数比较。
    * 不用考虑反转之后的int类型的整数溢出问题，因为若出现溢出则一定不是回文的。
    * 负数一定不是回文整数
    * **/
    public boolean solution(int x){
        int temp=x;
        if(x<0){
            return false;
        }
        int reslut=0;
        while(x>0){
            reslut=reslut*10+x%10;
            x=x/10;
        }

        System.out.println(reslut+" "+temp);
        if(reslut==temp){
            return true;
        }else {
            return false;
        }
    }


    /*
    * 官方解法：反转该整数的一半，然后将反转得到的数与剩下的一半进行比较。
    * 优点：只用对一半的数进行处理耗时少；不会出现反转后溢出的情况
    * 判断一半的方法：将原始数字除以 10，然后给反转后的数字乘上 10，
    * 所以，当原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字
    * **/
    public boolean solution2(int x){

        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }
    public static void main(String []args){

        IsPalindrome isPalindrome=new IsPalindrome();

        int x=121;
        System.out.println(isPalindrome.solution(x));
        }
}
