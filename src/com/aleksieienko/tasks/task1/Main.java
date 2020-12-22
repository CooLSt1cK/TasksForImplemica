package com.aleksieienko.tasks.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer number = 1;
        List<String> current = new ArrayList<>();
        current.add("()");
        List<String> newList = new ArrayList<>();
        String temp;
        Integer countBrackets = 0;

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input number of brackets:");
            countBrackets = scanner.nextInt();
            if (countBrackets <= 0) {
                System.out.println("Count of brackets should be positive integer number ");
            }
        } catch (Exception e){
            System.out.println("Count of brackets should be a number ");
            return;
        }


        while (number<countBrackets) {
            for (String s : current) {
                for (int i = 0; i < s.length(); i++) {
                    // Add "()" before each "(" or ")" and add in list if it is not contain
                    temp = s.substring(0,i)+"()"+s.substring(i,s.length());
                    if (newList.contains(temp)) {
                        continue;
                    }
                    newList.add(temp);
                }
            }

            // Prepare next step
            current = newList;
            newList = new ArrayList<>();
            number++;
        }

        System.out.println("Correct brackets expressions = "+current.size());
        System.out.println(current.toString());

    }

}
