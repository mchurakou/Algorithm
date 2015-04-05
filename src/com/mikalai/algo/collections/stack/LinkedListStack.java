package com.mikalai.algo.collections.stack;

import java.util.Iterator;
import java.util.Stack;

public class LinkedListStack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;

    }

    private class Node{
        Item item;
        Node next;
    }


    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>(){
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;

                return item;
            }
        };
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        stack.push("6");

        for (String s : stack){
            System.out.println("el:" + s);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
