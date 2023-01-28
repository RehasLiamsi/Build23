package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello There!");
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static boolean odd(int a) {
        if (a % 2 == 1){
            return true;
        }
        else
            return false;
    }
}
