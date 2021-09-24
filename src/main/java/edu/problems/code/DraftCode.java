package edu.problems.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DraftCode implements A, B{
    public static void main(String[] args) {
        List<String> s = new ArrayList<>(Arrays.asList("a","ab","abc"));
        //s.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList()).forEach(System.out::println);

        List l2 = new ArrayList();
        l2.add(null);
        l2.add(null);

        System.out.println(l2.get(2));
    }

    @Override
    public void my() {
        A.super.my();
    }
}

interface A{
    default void my(){}
}

interface B{
    default void my(){}
}
