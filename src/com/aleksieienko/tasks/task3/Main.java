package com.aleksieienko.tasks.task3;

import java.math.BigInteger;

public class Main {

    // It calculates factorial of number
    private static BigInteger factorial(BigInteger integer){
        if(integer.intValue() == 1){
            return BigInteger.ONE;
        } else {
            // It's equals to: integer * (integer - 1)
            return integer.multiply(factorial(BigInteger.valueOf(integer.intValue()-1)));
        }
    }

    // It counts sum digits of number
    private static BigInteger countDigits(BigInteger bigInteger){

        BigInteger[] arr = bigInteger.divideAndRemainder(BigInteger.valueOf(10));

        if(arr[0].equals(BigInteger.ZERO)){
            return arr[1];
        } else {
            return arr[1].add(countDigits(arr[0]));
        }
    }

    public static void main(String[] args) {

        BigInteger fact = factorial(BigInteger.valueOf(1000));
        System.out.println(countDigits(fact));

    }

}
