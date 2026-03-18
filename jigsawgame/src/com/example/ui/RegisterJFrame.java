package com.example.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {

    public RegisterJFrame(){

        // 初始化界面
        initFrame();

        // 以后再说！！！

        // 可视化
        this.setVisible(true);
    }

    private void initFrame() {

        // 设置界面宽高
        this.setSize(488, 500);
        // 设置界面标题
        this.setTitle("GameRegister");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
