package com.zwm;


import java.util.Arrays;


/**
 * 4.寻找两个正序数组的中位数
 */
public class Lab4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * author:zwm
         *

        int[] ints = Arrays.copyOf(nums1, nums1.length + nums2.length);//复制nums1
        System.arraycopy(nums2, 0, ints, nums1.length, nums2.length);//复制nums2
        Arrays.sort(ints);//正序排序
        double result = ints[ints.length / 2];
        if (ints.length % 2 == 0) {

            result = result + ints[(ints.length-1) / 2 ];
            System.out.println(result / 2);
            return result / 2;
        } else {
            System.out.println(result);
            return result;
        }

    }
*/

        /**
         * 二分查找法
         */
            int m = nums1.length;
            int n = nums2.length;
            int len = m + n;
            int left = -1, right = -1;
            int aStart = 0, bStart = 0;
            for (int i = 0; i <= len / 2; i++) {
                left = right;
                if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                    right = nums1[aStart++];
                } else {
                    right = nums2[bStart++];
                }
            }
            if ((len & 1) == 0)
                return (left + right) / 2.0;
            else
                return right;
        }

    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        lab4.findMedianSortedArrays(nums1, nums2);
    }
}
