package edu.problems.cracking_code_interview.chapter1.datastructures;

import java.util.Objects;

public class MyArrayList<T> {
    private static final int INITIAL_DEFAULT_SIZE = 10;
    private Object[] elements;
    private int size;

    public MyArrayList(){
        elements = new Object[INITIAL_DEFAULT_SIZE];
    }
    public MyArrayList(int size){
        elements = new Object[size];
    }
    public MyArrayList(T[] elements){
        this.elements = elements;
    }

    public void add(T e){
        if(size == elements.length){
            resize();
        }
        elements[size++] = e;
    }

    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0,elements.length);
        elements = newArray;
    }

    public <T> T get(int index){
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        System.arraycopy(elements, index + 1, elements, index, size-index-1);
        size--;
    }
}
