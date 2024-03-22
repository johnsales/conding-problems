package edu.problems.grid_dynamics;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculationExample {
    public static void main(String[] args) {
        BigDecimal annualRate = new BigDecimal("0.05"); // 5% annual rate
        BigDecimal daysInYear = new BigDecimal("365");
        BigDecimal dailyRate = annualRate.divide(daysInYear, 8, RoundingMode.HALF_UP);

        System.out.println(String.format("dailyRate: %s", dailyRate));

        BigDecimal principal = new BigDecimal("1000.00");
        for(int day = 1; day <= 10; day++) {
            BigDecimal dailyInterest = principal.multiply(dailyRate).setScale(2, RoundingMode.HALF_UP);
//            System.out.println(String.format("dailyInterest: %s", dailyInterest));
            principal = principal.add(dailyInterest);
            System.out.println(String.format("temp principal: %s", principal));

        }

        System.out.println("Final amount after 10 days: $" + principal.setScale(2, RoundingMode.HALF_UP));
    }
}
