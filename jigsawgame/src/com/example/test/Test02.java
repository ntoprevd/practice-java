package com.example.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test02 {
    public static void main(String[] args) {

        // 匿名内部类方式

        // 初始化界面
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);

        // 设置按钮
        JButton jButton = new JButton("按钮");
        jButton.setBounds(0, 0, 100, 50);

        jButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击按钮+1");
            }
        });

        jFrame.getContentPane().add(jButton);
        jFrame.setVisible(true);
    }
}
