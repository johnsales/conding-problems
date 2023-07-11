package edu.problems.cracking_code_interview.chapter1;

public class OneAway {
    public static void main(String[] args) {
        System.out.println(isOneEditWay("pale","ple")); //true
        System.out.println(isOneEditWay("pales","pale")); //true
        System.out.println(isOneEditWay("pale","bale")); //true
        System.out.println(isOneEditWay("pale","bake")); //false
    }

    //insert, delete, update
    static boolean isOneEditWay(String s1, String s2){
        if(Math.abs(s1.length() - s2.length()) > 1) return false;

        String first = s1.length() < s2.length() ? s1 : s2;
        String second = s1.length() < s2.length() ? s2 : s1;
        int indexFirst = 0, indexSecond = 0;
        boolean hasOneAway = false;

        while (indexFirst < first.length() && indexSecond < second.length()){
            if(first.charAt(indexFirst) != second.charAt(indexSecond)){
                if(hasOneAway) return false;
                hasOneAway = true;

                if(first.length() == second.length()) indexFirst++;
            } else{
                indexFirst++;
            }
            indexSecond++;
        }
        return true;
    }
}
