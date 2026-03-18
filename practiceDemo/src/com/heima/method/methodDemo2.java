package com.heima.method;

public class methodDemo2 {
    
    public static void main(String[] args) {
        
        System.out.println(compare(3.2, 3.4));
        System.out.println(compare(3, 3));
        System.out.println(compare(3.22, 3));

    }

    public static String compare(double num_1, double num_2){
        return num_1 == num_2 ? "yes":"no";
    }

    public static String compare(int num_1, int num_2){
        return num_1 == num_2 ? "yes":"no";
    }
}
