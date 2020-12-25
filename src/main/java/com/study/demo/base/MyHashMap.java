package com.study.demo.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName MyHashMap
 * @Description 自定义HashMap
 * @Author dongzhanjun
 * @Date 2020/5/1 12:03
 * @Version 1.0
 */
public class MyHashMap {
    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>();
        map.put(1,"jack");
        map.put(2,"john");
        map.put(3,"lucy");
        map.put(4,"lily");
        System.out.println("jack".hashCode());
        System.out.println(map.get(1));
    }

    Map map = new HashMap();
    static class Node<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }




}
