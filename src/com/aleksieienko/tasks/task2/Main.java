package com.aleksieienko.tasks.task2;

import com.aleksieienko.tasks.task2.pipeline.Graph;
import com.aleksieienko.tasks.task2.pipeline.Point;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter number of tests: ");
            Integer s = scanner.nextInt();
            for(int i = 0; i < s; i++){

                System.out.print("Enter number of cities: ");
                Integer n = scanner.nextInt();
                Graph graph = new Graph(n);
                for(int j = 0; j < n; j++){
                    System.out.print("Enter name of city: ");
                    String name = scanner.next();
                    graph.addPoint(new Point(name));

                    System.out.print("Enter number of neighbors of city " + name + ": ");
                    Integer p = scanner.nextInt();
                    System.out.println("Enter neighbors of city " + name + ", namely city's id and cost, " + p + " times:");
                    for(int k = 0; k < p; k++){
                        graph.addEdge(graph.getPointByName(name).getId(), scanner.nextInt(), scanner.nextInt());
                    }
                }

                System.out.print("Enter number of paths to find: ");
                Integer r = scanner.nextInt();
                System.out.println("Enter paths, namely name1(source) and name2(destination), " + r + " times:");
                for(int j = 0; j < r; j++){
                    System.out.println(graph.shortestRouteWeight(scanner.next(),scanner.next()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
