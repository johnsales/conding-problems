package edu.problems.code;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStackGenericArray<T extends Comparable<T>> {
    private T[] array;
    private int size, top;
    private T min;

    public MyStackGenericArray(Class<T> clazz, int size){
        this.array = (T[]) Array.newInstance(clazz,size);
        this.size = size;
        this.top = -1;
    }

    public void push(T newValue){
        if(top + 1 == size) {
            System.err.println("Stack Overflow");
            return;
        }
        top++;
        array[top] = newValue;
        if(min == null) min = newValue;
        if(min.compareTo(newValue) == 1) min = newValue;
    }

    public void pop() {
        if(top == -1){
            System.err.println("Stack Overflow");
            return;
        }
        array[top--] = null;
    }

    public T peek(){
        return array[top];
    }

    @Override
    public String toString() {
        return "MyStackArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", top=" + top +
                ", min=" + min +
                '}';
    }

    public static void main(String[] args) {
        MyStackGenericArray<Integer> stack = new MyStackGenericArray<>(Integer.class, 5);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.reverse();


        System.out.println(stack);
    }

    private void reverse() {
        //TODO
    }

}
