package com.zwm;

/**
 * 11. 盛最多水的容器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class Lab11 {
    /**
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1,result = 0;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left = left + 1;
            else right = right - 1;
        }
//        System.out.println(result);
        return result;
    }

    /**
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Lab11 lab11 = new Lab11();
        lab11.maxArea(height);
    }
}
