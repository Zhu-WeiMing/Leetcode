package com.zwm;

import java.util.HashMap;
import java.util.Map;

public class Lab1 {

    public int[] twoSum(int[] nums, int target) {

        /**
         * 暴力解法
         * 第一个元素分别和剩下的元素相加判断是否等于target
         * 剩下的元素依此类推
         * author：zwm
         */
//        int[] result = new int[2];
//        int index = 0;
//        //遍历数组
//        for(int num : nums) {
//            for (int i = 1+index; i < nums.length; i++) {
//                if (num + nums[i] == target ) {
//                    result[0] = index;
//                    result[1]= i;
//                    return result;
//                }
//            }
//            index++;
//        }
//       return null;
/**
 * 标签：哈希映射
 * 这道题本身如果通过暴力遍历的话也是很容易解决的，时间复杂度在 O(n2)
 * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
 * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
 * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
 * 如果最终都没有结果则抛出异常
 * 时间复杂度：
 *
 * 作者：画手大鹏
 * 链接：https://leetcode.cn/problems/two-sum/solutions/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //判断map的key是否存在 target-nums[i]
            if(map.containsKey(target-nums[i])){
                //存在，就返回下标
                return new int[] {map.get(target-nums[i]),i};
            }
            //不存在，就存入map中
            map.put(nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
	// write your code here
        Lab1 lab1 = new Lab1();
        int[] in = {2,5,5,11};
        int[] ints = lab1.twoSum(in, 10);
//        System.out.println(Array.toString);
        for(int a:ints){
            System.out.println(a);
        }

    }
}
