package com.example.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    public MyJFrame2() {

        // 设置界面宽高
        this.setSize(603, 680);
        // 设置界面标题
        this.setTitle("鼠标监听");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中位置，是的组件按照xy放置
        this.setLayout(null);

        // 设置按钮
        JButton jbt = new JButton("我是按钮");
        jbt.setBounds(0, 0, 150, 100);

        // 法一：匿名内部类
        /*jbt.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击鼠标");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("按下不松");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("松开鼠标");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("划入");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("划出");
            }
        });*/

        // 法二：a extends b implements c
        this.addMouseListener(this);

        this.getContentPane().add(jbt);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击鼠标");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开鼠标");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
