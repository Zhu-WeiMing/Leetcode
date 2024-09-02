package com.zwm;

import jdk.internal.org.objectweb.asm.tree.LineNumberNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Stream;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class Lab15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        if(!result.contains(list)){
                            result.add(list);
                        }
                    }
                }
            }
        }


//        [[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Lab15 lab15 = new Lab15();
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        lab15.threeSum(nums);
    }
}
