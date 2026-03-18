package com.example.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    // a extends b implements c
    JButton jbt1 = new JButton("按钮1");
    JButton jbt2 = new JButton("按钮2");

    public MyJFrame(){

        // 设置界面宽高
        this.setSize(603, 680);
        // 设置界面标题
        this.setTitle("动作监听");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中位置，是的组件按照xy放置
        this.setLayout(null);

        // 设置按钮

        jbt1.setBounds(0, 0, 100, 50);
        jbt2.setBounds(300, 0, 100, 50);

        // 设置监听
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);

        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(jbt1)){
            jbt1.setSize(300, 300);
        } else if (source.equals(jbt2)) {
            Random r = new Random();
            jbt2.setLocation(r.nextInt(500), r.nextInt(500));
        }

    }
}
