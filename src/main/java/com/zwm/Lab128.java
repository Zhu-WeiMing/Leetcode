package com.zwm;

import org.jcp.xml.dsig.internal.dom.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Lab128 {
    /**
     * public int longestConsecutive(int[] nums) {
     * //排序
     * Arrays.sort(nums);
     * int result = 1;
     * if(nums.length ==0){
     * result = 0;
     * }
     * for(int start = 0 ,end = 0 ; end<nums.length; end++){
     * if(end > 0){
     * <p>
     * }
     * if (nums[end] == nums[end - 1] +1 || nums[end] == nums[end - 1]) {
     * result = Math.max(result, end - start);
     * <p>
     * }else {
     * result = Math.max(result, end - start);
     * start = end ;
     * }
     * }
     * System.out.println(result);
     * return result;
     * }
     */

    public int longestConsecutive(int[] nums) {
        //set集合：无序不可重复
        Set<Integer> hash = new HashSet<Integer>();
        //将nums插入到set集合中
        for (int x : nums) hash.add(x);    //放入hash表中
        //结果
        int res = 0;
        for (int x : hash) {
            //去找hash里面是否有x-1的数
            if (!hash.contains(x - 1)) {
                //没有
                int y = x;   //以当前数x向后枚举 y代替x为起点
                //先看下一个数有没有 没有直接走出while 有就往下走直到查找到最后一个连续数 y则为终点
                while (hash.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);  //更新答案
            }
        }
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        Lab128 lab128 = new Lab128();
        int[] input = {0, -2};
        lab128.longestConsecutive(input);
    }
}
