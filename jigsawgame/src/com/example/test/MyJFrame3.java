package com.example.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {

    public MyJFrame3() {

        // 设置界面宽高
        this.setSize(603, 680);
        // 设置界面标题
        this.setTitle("键盘监听");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中位置，是的组件按照xy放置
        this.setLayout(null);

        // 法一：匿名内部类
        /*  this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("按下不松");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("松开");
            }
        });*/

        // 法二：a extends b implements c
        this.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");

        int keyCode = e.getKeyCode();
        System.out.println(keyCode);

        if(keyCode == 65){
            System.out.println("敲击了A");
        } else if (keyCode == 66) {
            System.out.println("敲击了B");
        }else{
            System.out.println("敲击了其他键");
        }
    }
}
