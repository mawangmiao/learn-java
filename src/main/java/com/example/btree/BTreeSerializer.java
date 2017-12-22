package com.example.btree;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeSerializer {

    private static final String EMPTY_LEAF = "$";
    private static final String SEPERATOR  = ",";

    public static String serialize(BTreeNode<Integer> root) {
        if (root == null) return null;

        StringBuilder stringBuilder = new StringBuilder();
        serializeInternal(root, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        String data = stringBuilder.toString();
        System.out.println("------序列化成字符串------");
        System.out.println(data);
        return data;
    }

    private static void serializeInternal(BTreeNode<Integer> root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(EMPTY_LEAF);
            stringBuilder.append(SEPERATOR);
            return;
        }
        stringBuilder.append(root.data).append(SEPERATOR);
        serializeInternal(root.left, stringBuilder);
        serializeInternal(root.right, stringBuilder);
    }

    public static BTreeNode<Integer> deserialize(String data) {
        if (StringUtils.isBlank(data)) return null;

        System.out.println("------从字符串反序列化------");
        System.out.println(data);
        String[] strings = data.split(SEPERATOR);
        Queue<String> queue = new LinkedList<>();
        for (String str : strings) {
            queue.offer(str);
        }

        return serializeInternal(queue);
    }

    private static BTreeNode<Integer> serializeInternal(Queue<String> queue) {
        String data = queue.poll();
        //退出条件
        if (data == null || data.equals(EMPTY_LEAF)) {
            return null;
        }

        //反序列化自己
        BTreeNode<Integer> root = new BTreeNode<>(Integer.valueOf(data));
        //递归反序列化左边
        root.left = serializeInternal(queue);
        //递归反反反序列化右边
        root.right = serializeInternal(queue);
        return root;
    }

}
