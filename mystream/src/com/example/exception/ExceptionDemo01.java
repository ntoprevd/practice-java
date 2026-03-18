package com.example.exception;

public class ExceptionDemo01 {

    static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};

        /*try {
            System.out.println(2 / 0);
            System.out.println(arr[10]);
            System.out.println(2 / 0);
            String s = null;
            System.out.println(s.equals("aaa"));

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("数组索引越界异常");

        } catch (ArithmeticException e) {

            System.out.println("算数异常");

        } catch (NullPointerException e) {

            System.out.println("空指针异常");

        } catch (Exception e) {

            System.out.println("异常！");
        }*/

        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }

        System.out.println("我执行了吗？我靠，为什么顺序是这样？");
    }
}
