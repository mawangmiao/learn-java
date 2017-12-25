package com.example.algorithm;

import org.apache.commons.lang3.StringUtils;

public class LongestNonDuplicateSubstringTest {

    public static void main(String[] args) {
        String str = null;
        System.out.println(str);
        System.out.println("中不含重复字符的子字符串最大长度为" + getLength(str) + ", 期望值" + 0);

        str = "arabcacfr";
        System.out.println(str);
        System.out.println("中不含重复字符的子字符串最大长度为" + getLength(str) + ", 期望值" + 4);

        str = "a";
        System.out.println(str);
        System.out.println("中不含重复字符的子字符串最大长度为" + getLength(str) + ", 期望值" + 1);

        str = "aa";
        System.out.println(str);
        System.out.println("中不含重复字符的子字符串最大长度为" + getLength(str) + ", 期望值" + 1);

        str = "abc";
        System.out.println(str);
        System.out.println("中不含重复字符的子字符串最大长度为" + getLength(str) + ", 期望值" + 3);
    }

    private static int getLength(String str) {
        if (StringUtils.isBlank(str)) return 0;

        int maxLength = 0, currentLength = 0;
        int[] lastSeen = initLastSeenArray();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int charCode = chars[i] - 'a';

            if (lastSeen[charCode] == -1) {//处于位置i的字符第一次出现
                currentLength++;
            } else {//之前出现过
                //计算跟当前字符的距离
                int distance = i - lastSeen[charCode];
                if (distance > currentLength) {//如果距离大于currentLength, length++, 更新i
                    currentLength++;
                } else {//如果小于等于currentLength
                    currentLength = distance;
                }
            }

            lastSeen[charCode] = i;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }

    private static int[] initLastSeenArray() {
        int[] lastSeen = new int[26];
        for (int i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }
        return lastSeen;
    }
}
