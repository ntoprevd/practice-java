package com.heima.demo6;

import java.util.ArrayList;

public class ArrListDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("我叫齐夏");
        list.add("是个骗子");
        list.add("我的话只能信一半");
        list.add("余念向来难安");
        list.add("而我一直孤单");

        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                System.out.print(list.get(i));
            }
            else{
                System.out.print(list.get(i) + "，");
            }
        }
        System.out.print("]");
    }
}
