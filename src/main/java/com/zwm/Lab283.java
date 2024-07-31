package com.zwm;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时让非零元素的顺序排序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Lab283 {
    public void moveZeroes(int[] nums) {
        int notZero = 0; //3
        //获取非零点
        for (int num : nums) {
            if (num == 0) {
                notZero++;
            }
        }
        if (notZero == 0) return;
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            if (nums[nums.length - 1] != 0 && i + notZero < nums.length) {
                int tem = nums[i + notZero];
                nums[i + notZero] = nums[i];
                nums[i] = tem;
            }
        }

    }

    public static void main(String[] args) {
        Lab283 lab283 = new Lab283();
        int[] input = {0,1,0,3,12};//1230005
        lab283.moveZeroes(input);
    }
}
