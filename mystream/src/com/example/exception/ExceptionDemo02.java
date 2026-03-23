package com.example.exception;

public class ExceptionDemo02 {

    static void main(String[] args) {

        // throw   throws

        int[] arr = {};
        int max = 0;
        try {
            max = getMax(arr);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组索引越界异常！");
        } catch (NullPointerException e) {
            System.out.println("空指针异常！");
        } catch (Exception e) {
            System.out.println("异常！");
        }

        System.out.println(max);
    }

    public static int getMax(int[] arr) {

        if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (arr == null) {
            throw new NullPointerException();
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }

        }

        return max;
    }
}
