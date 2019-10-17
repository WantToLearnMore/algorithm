package com.priactice.algorithm.checkHome;

public class LongestPalindrom {

    /*
    *最长公共子串法（此处使用动态规划寻找最长公共子串）
    * 整体思想：
    * 将字符串S 反转为S‘,通过S和S’比较，利用动态规划先得到最长公共子串
    * S和S‘分别置于横、纵坐标，通过网格（二维数组）一 一比较子串（每一个就是一个子问题，
    * 且是离散的不依赖其他子问题），当公共子串的长度等于前面公共子串的长度加一，网格记录
    * 当前公共子串的长度
    *
    * 申请一个二维的数组初始化为0，然后判断对应的字符是否相等
    * arr[i][j]=arr[i-1][j-1]+1（状态转移方程），存的是当前字串的长度
    * 当i=0或j=0的时候单独分析，字符相等的话arr[i][j]就为1
    * a[i][j]保存的就是公共字串的长度。
    * 但是求出的最长公共子串不一定是回文串，此时还需要判断该字符串倒置前的下标
    * 和当前的字符的字符串下标是不是匹配。
    * **/
    public String solution1(String s){

        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();//反转字符串
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;//最长公共子串长度
        int maxEnd = 0;//最长公共子串结束位置
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;//公共子串长度
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    /*
    * 中心扩展算法
    * 回文中心的两侧互为镜像。因此回文可以从它的中心展开，并且只有2n-1个这样的中心。
    *之所以是2n-1个中心而不是n个中心，原因在于所包含字母数为偶数的回文的中心可以处于两个字母之间，如abba
    * 时间复杂度o（n*n） 空间复杂度o（1）
    * **/
    public String solution2(String s){
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
