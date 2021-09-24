package edu.problems.code;

import java.util.ArrayList;
import java.util.List;

public class MyStackArrayList<T> {

    private List<T> list;
    private int size;
    private int top = -1;

    public MyStackArrayList(){
        this.list = new ArrayList<>();
    }

    public MyStackArrayList(int size){
        this.size = size;
        this.list = new ArrayList<>(size);
    }

    void push(T value){
        if(top + 1 == size)
            System.err.println("Stack Overflow");
        else{
            top++;
            if(list.size() > top)
                list.set(top, value);//?
            else
                list.add(value);
        }
    }

    T top(){
        if(top == -1) {
            System.err.println("Stack Underflow");
            return null;
        }
        return list.get(top);
    }

    void pop(){
        if(top == -1)
            System.err.println("Stack Underflow");
        else{
            top--;
        }
    }

    boolean isEmpty() { return top == -1; }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < top; i++) {
            builder.append(list.get(i) + "->");
        }
        builder.append(list.get(top));

        return builder.toString();
    }
}
