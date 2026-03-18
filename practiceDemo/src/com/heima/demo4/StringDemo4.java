package com.heima.demo4;

import java.util.Scanner;

public class StringDemo4 {
    public static void main(String[] args) {

        // 1. 键盘录入正确金额
        Scanner sc = new Scanner(System.in);
        int money;

        while (true) {
            System.out.println("请输入一个金额：");
            money = sc.nextInt();

            if (money >= 0 && money <= 99999999) {
                break;
            } else {
                System.out.println("金额无效！");
            }
        }

        // 2. 把金额转换成大写，2134 -> 壹贰叁肆
        String bigMoney = getBigNumber(money);

        // 3. 在前方补零，满足一共八位
        String bigMoneyWithZero = zeroFill(bigMoney);

        // 4. 插入仟佰拾万
        String realMoney = getRealMoney(bigMoneyWithZero);

        System.out.println(realMoney);
    }

    public static String getBigNumber(int money) {
        String[] arr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};

        String bigMoney = "";

        while (money != 0) {
            // 得到money的每个数字
            int ge = money % 10;
            bigMoney = arr[ge] + bigMoney;
            money = money / 10;
        }
        return bigMoney;
    }

    public static String zeroFill(String bigMoney){
        int count = 8 - bigMoney.length();

        for (int i = 0; i < count; i++) {
            bigMoney = "零" + bigMoney;
        }
        return bigMoney;
    }

    public static String getRealMoney(String bigMoneyWithZero){
        String[] arr = {"仟", "佰", "拾", "万", "仟", "佰", "拾", ""};
        String realMoney = "";

        for (int i = 0; i < bigMoneyWithZero.length(); i++) {
        realMoney = realMoney + bigMoneyWithZero.charAt(i) + arr[i];
        }
        return realMoney;
    }
}
