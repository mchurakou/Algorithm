package com.mikalai.algo.collections.stack;

import java.util.Iterator;

/**
 * Created by badbug on 05.04.2015.
 */
public class LinkedListQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        } else {
            oldlast.next = last;
        }

        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }

        N--;
        return item;

    }

    private class Node{
        Item item;
        Node next;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        LinkedListQueue<String> stack = new LinkedListQueue<>();
        stack.enqueue("1");
        stack.enqueue("2");
        stack.enqueue("3");
        stack.enqueue("4");
        stack.enqueue("5");

        stack.enqueue("6");

//        for (String s : stack){
//            System.out.println("el:" + s);
//        }
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
    }
}
