package com.study.demo.test;

import java.util.*;

/**
 * @ClassName LinkTest
 * @Description MyLinkedList
 * @Author dongzhanjun
 * @Date 2020/12/16 10:28
 * @Version 1.0
 */
public class MyLinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    //双向链表，内部节点
    private static class Node<E>{
         E e;
         Node<E> prev;
         Node<E> next;
        public Node(E e, Node<E> prev, Node<E> next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }
    }

    //总数
    private int size=0;

    //第一个节点
    private Node<E> first;

    //第一个节点
    private Node<E> last;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends E> all) {
        this();
        addAll(all);
    }

    /**
     * 增加第一个元素
     */
    private void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(e,null,f);
        if(size==0){
            last = newNode;
        }else {
            first.prev = newNode;
        }
        first= newNode;
        size++;
        modCount++;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.linkFirst(1);
        myLinkedList.linkFirst(2);
        System.out.println("args = " + Arrays.deepToString(args));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
    }







    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {

    }

    @Override
    public void addLast(E e) {

    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }



}
