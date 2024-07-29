package com.zwm;

import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import netscape.security.UserTarget;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列
 * 流
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词，
 */
public class Lab49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,String> map = new HashMap();
            for (String str : strs){
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String strC = String.valueOf(chars);
                if(!map.containsKey(strC)){
                    map.put(strC,str);

                }else {
                    String newValue = map.get(strC) + "," + str;
                    map.put(strC,newValue);
                }

            }

        System.out.println(map);
        /**
         * {aet=eat,tea,ate, abt=bat, ant=tan,nat}
         */
        System.out.println("result："+result);
        return result;

    }

    public static void main(String[] args) {
        Lab49 lab49 = new Lab49();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        lab49.groupAnagrams(input);
    }
}

/**
 * class Solution {
 *     public List<List<String>> groupAnagrams(String[] strs) {
 *     Map<String, List<String>> map = new HashMap<String, List<String>>();
 *          //遍历字符串数组
 *         for (String str : strs) {
 *         //转化为char[]类型，便于排序
 *         char[] array = str.toCharArray();
 *         //排序
 *         Arrays.sort(array);
 *         //排序后的char转为Sring类型并为后续作为key。强引用：在程序内存不足（OOM）的时候也不会被回收。
 *         String key = new String(array);
 *
 *         //从map中根据key获取value，如果没有就新建数组
 *         //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
 *         List<String> list = map.getOrDefault(key, new ArrayList<String>());
 *         //添加到list
 *         list.add(str);
 *         //放入map中
 *         map.put(key, list);
 *         }
 *     return new ArrayList<List<String>>(map.values());
 *     }
 * }
 */



