package com.priactice.algorithm.checkHome;

public class FindMedianSortedArrays {

    /*
    我们需要找出两个排序数组的第k个数的问题。比较两个数组的第k/2位，
    然后将第k/2位较小的数组中的前k/2位删除。
    然后继续此过程

    举个例子
    A={1,3,4,9} lenA=4  B={1,2,3,4,5,6,7,8,9} lenB=9  lenA+lenB=13 ，因此找第7个数

    7/2 = 3   A的第3个数为4，B的第3个数为3，  因此接下来A={1,3,4,9}   B={4,5,6,7,8,9}  找第7-3=4个数，
    4/2=2 A的第2个数为3，B的第3个数为6，  因此接下来A={4,9}   B={4,5,6,7,8,9}   找第4-2=2个数，
    2/2=1 A的第1个数为4，B的第1个数为4，  因此接下来A={4}   B={5,6,7,8,9}   找第2-1=1个数，
    现在找第1个数，比较A[0]和B[0]谁更小即可，因此最后结果为4
   **/
    public double solution(int []A,int[] B){
        int m = A.length;
        int n = B.length;
        StringBuffer stringBuffer=new StringBuffer();
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
