package com.priactice.algorithm.checkHome;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*时间复杂度o（n*n）空间复杂度o（1）
    *
    * **/
    public int[]twoSum(int []nums,int target){
        int reslut[]= {0,0};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    reslut[0]=i;
                    reslut[1]=j;
                }
            }
            if(i==nums.length){
                reslut[0]=-1;
                reslut[1]=-1;
            }
        }
        return reslut;
    }


    /*
    * 利用hash表存储元素，在遍历元素时同时在已存入的元素中进行怕匹配。
    * **/
    public int[] solution2(int []nums,int target){
        int result[]={-1,-1};
        Map map=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=(int) map.get(target-nums[i]);
                result[1]=i;
                return result;
            }
            map.put(nums[i],i);
        }

        return result;

    }


    public static void main(String[]args){

        int nums[]={3,2,4};
        TwoSum twoSum=new TwoSum();
        System.out.println(twoSum.solution2(nums,6)[0]);
        System.out.println(twoSum.solution2(nums,6)[1]);
    }
}
