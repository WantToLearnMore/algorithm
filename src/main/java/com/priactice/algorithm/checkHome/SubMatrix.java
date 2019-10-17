package com.priactice.algorithm.checkHome;

public class SubMatrix {

    /**
     * 求矩阵的最大子矩阵的和
     * 思路是将二维的矩阵化为一维的数组，求一维数组的最大连续子序列的和
     * @param mat 二维矩阵n*n
     * @param n 矩阵的阶数
     * @return 返回最大子矩阵的和
     */
    public int sumOfSubMatrix(int[][] mat, int n) {
        int[] temp = new int[n];
        //初始化
        for(int i = 0;i<n;i++)
            temp[i] = 0;
        int max = Integer.MIN_VALUE;

        //从第一行开始往下加...从第二行开始往下加......从第n行开始往下加
        for(int i  = 0;i<n;i++){
            //temp只加了一行
            temp = mat[i];
            max = (maxSubArray(temp,n)>max)?maxSubArray(temp,n):max;
            //temp开始往下加第二行，第三行...
            for(int j = i+1;j<n;j++){
                for(int k = 0;k<n;k++){
                    temp[k] +=mat[j][k];
                }
                //每加完一行之后，比较一下最大值
                max = (maxSubArray(temp,n)>max)?maxSubArray(temp,n):max;
            }
        }
        return max;
    }

    /**
     * 求一位数组的最大连续子序列的和
     * @param array 传递进去的一位数组
     * @param n 数组的长度
     * @return 返回连续最大连续子序列的和
     */
    public  int maxSubArray(int[] array,int n){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            sum+=array[i];
            if(sum<0)
                sum=0;
            if(sum>max)
                max = sum;
        }
        return max;
    }
    public  static void main(String[]args){
        int a[][]={{-1,2},{-3,6}};

        SubMatrix t=new SubMatrix();
       int tem= t.sumOfSubMatrix(a,2);

       System.out.println(tem);
    }
}
