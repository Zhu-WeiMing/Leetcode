package com.zwm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lab3 {
    /**
     * author:zwm
     * 暴力解法 未解出
     *
     * @param s
     * @return public int lengthOfLongestSubstring(String s) {
     * List list = new ArrayList();
     * //遍历字符串
     * for (int i = 0; i < s.length(); i++) {
     * char c = s.charAt(i);
     * //强转String
     * String s1 = String.valueOf(c);
     * if (list.size() == 0) {
     * list.add(s1);
     * } else {
     * if (list.contains(s1)) {
     * String o = String.valueOf(list.get(list.size() - 1));
     * if (o.equals(s1) && c == s.charAt(i-1)) {
     * list.clear();
     * list.add(s1);
     * }
     * } else {
     * list.add(s1);
     * }
     * }
     * }
     * System.out.println(list.size());
     * return list.size();
     * }
     */


    /**
     * 作者：画手大鹏
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/7399/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     */
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int end = 0, start = 0; end < n; end++) {//右指针每次向右一格移动
//            char alpha = s.charAt(end);
//            if (map.containsKey(alpha)) {
//                Integer i = map.get(alpha);  //cdedcradd
//                start = Math.max(i, start);//左指针向有移动到重复的值那
//            }
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end + 1);
//        }
//        System.out.println(ans);
//        return ans;
//    }


    /**
     * 自己理解并编写 滑动窗口
     *
     * @param s
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0, start = 0 ,end = 0;
        //Character - char的包装类
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //遇到相同的元素
            if (map.containsKey(c)) {
                start = i - map.get(c);
                end = i;
            }
            end +=1;
            map.put(c, i + 1);
        }
        System.out.println(end - start);
        return end-start;
    }
    public static void main(String[] args) {
        Lab3 lab3 = new Lab3();
        lab3.lengthOfLongestSubstring("cdedcra");
    }
}