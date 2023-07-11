package edu.problems.cracking_code_interview.chapter1.datastructures;

public class MyStringBuilder {
    private char[] value;
    private int size = 0;

    public MyStringBuilder() {
        value = new char[16];
    }

    public MyStringBuilder append(String str) {
        ensureCapacity(size + str.length());
        str.getChars(0, str.length(), value, size);
        size += str.length();
        return this;
    }

    public String toString() {
        return new String(value, 0, size);
    }

    private void ensureCapacity(int minimumCapacity) {
        if (minimumCapacity - value.length > 0) {
            int newCapacity = (value.length * 2) + 2;
            if (newCapacity < minimumCapacity) {
                newCapacity = minimumCapacity;
            }
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, size);
            value = newValue;
        }
    }
}

