package edu.problems.interviews.amazon;

import java.util.List;

public class MaxProductCalculator {

    public static void main(String[] args) {
//        List<Integer> products = List.of(7, 4, 5);
//        List<Integer> products = List.of(5, 2, 6, 5);
//         List<Integer> products = List.of(5, 2, 6);

        List<Integer> products = List.of(7);
        long maxProducts = findMaxProducts(products);
        System.out.println("Maximum number of products: " + maxProducts);
    }

    public static long findMaxProducts(List<Integer> products) {
        int n = products.size();
        int totalProducts = 0;

        for (int i = 0; i < n; i++) {
            int prodList = products.get(i);
            if(i == n -1){
                totalProducts+= prodList;
            } else{
                if(products.get(i) < products.get(i+1)){
                    totalProducts+= products.get(i);
                }else{
                    totalProducts+= products.get(i+1) -1;
                }
            }
        }
        return totalProducts;
    }


}


