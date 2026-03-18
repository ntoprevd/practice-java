package com.example.math;

public class Demo01 {
    static void main() {

        // 三位 100-999
        int count = 0;
        for (int i = 100; i < 1000; i++) {

            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;

            double sum = Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3);
            if(sum == i){
                System.out.print(i + " ");
                count++;
            }

        }
        System.out.println("水仙数：" + count);

        // 四位数 1000-9999
        count = 0;
        for (int i = 1000; i < 10000; i++) {

            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            int qian = i / 1000 % 10;

            double sum = Math.pow(ge, 4) + Math.pow(shi, 4) + Math.pow(bai, 4) + Math.pow(qian, 4);
            if(sum == i){
                System.out.print(i + " ");
                count++;
            }

        }
        System.out.println("四叶草数：" + count);

        // 五位数
        count = 0;
        for (int i = 10000; i < 100000; i++) {

            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            int qian = i / 1000 % 10;
            int wan = i / 10000 % 10;

            double sum = Math.pow(ge, 5) + Math.pow(shi, 5) + Math.pow(bai, 5) + Math.pow(qian, 5) + Math.pow(wan, 5);
            if(sum == i){
                System.out.print(i + " ");
                count++;
            }

        }
        System.out.println("五角星数：" + count);

        // 两位数
        count = 0;
        for (int i = 10; i < 100; i++) {

            int ge = i % 10;
            int shi = i / 10 % 10;

            double sum = Math.pow(ge, 2) + Math.pow(shi, 2);
            if(sum == i){
                System.out.print(i + " ");
                count++;
            }

        }
        System.out.println("两位数：" + count);

    }
}
