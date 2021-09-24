package edu.problems.code;

import java.util.concurrent.locks.ReentrantLock;

public class MyStackMyLinkedList {

    private MyLinkedList linkedList;
    ReentrantLock lock;

    public MyStackMyLinkedList(){
        linkedList = new MyLinkedList();
        lock = new ReentrantLock();
    }
    public void push(Integer value){
        lock.lock();
        try {
            linkedList.add(new Node(value));
        }finally {
            lock.unlock();
        }
    }

    public void pop(){
        lock.lock();
        try {
            linkedList.remove();
        }finally {
            lock.unlock();
        }
    }

    public Integer peek(){
        lock.lock();
        try {
            return linkedList.tail.getValue();
        }finally {
            lock.unlock();
        }
    }

    public int sizeAtConstantTime(){
        lock.lock();
        try {
            return linkedList.size;
        }finally {
            lock.unlock();
        }
    }

    public int minAtConstantTime(){
        lock.lock();
        try {
            return linkedList.tail.getMin();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyStackMyLinkedList stack = new MyStackMyLinkedList();
        stack.push(1);
        stack.push(3);
        stack.push(2);

        stack.pop();

        System.out.println(stack);
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

class MyLinkedList{
    Node head;
    Node tail;
    int size;

    void add(Node newNode){
        if(head == null) {
            newNode.setMin(newNode.value);
            head = newNode;
            tail = head;
        }
        else{
            Node tempNode = head;
            while (tempNode.next != null){
                tempNode = tempNode.next;
            }
            newNode.setMin(tempNode.min < newNode.value ? tempNode.min : newNode.value);
            tempNode.next = newNode;
            tail = tempNode.next;
        }
        size++;
    }

    void remove(){
        if(head == null)
            System.err.println("Cannot remove, empty stack!");
        else{
            Node tempNode = head;
            Node previous = null;
            while (tempNode.next != null){
                previous = tempNode;
                tempNode = tempNode.next;
            }
            previous.setNext(null);
            tail = previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node tempNode = head;
        while (tempNode.next != null){
            builder.append(tempNode.getValue() + " -> ");
            tempNode = tempNode.next;
        }
        builder.append(tempNode.getValue());
        return builder.toString();
    }
}

class Node {
    Integer value;
    Integer min;
    Node next;

    public Node (Integer value){
        this.value = value;
    }

    //Getters and Setters
    public Integer getValue() {return value;}
    public Integer getMin() {return min;}
    public Node getNext() {return next;}
    public void setValue(Integer value) {this.value = value;}
    public void setMin(Integer min) {this.min = min;}
    public void setNext(Node next) {this.next = next;}
}
