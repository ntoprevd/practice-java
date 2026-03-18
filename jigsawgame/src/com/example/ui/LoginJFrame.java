package com.example.ui;

import com.example.bean.User;
import com.example.util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {

    // 用户信息集合
    static ArrayList<User> list = new ArrayList<>();
    static{
        User u1 = new User("张三", "zhangsan123!");
        User u2 = new User("李四", "lisi123!");
        list.add(u1);
        list.add(u2);
    }

    // 监听中要用到，初始化界面内容要用到
    JButton logJbt = new JButton(new ImageIcon("image\\login\\登录按钮.png"));
    JButton registerJbt = new JButton(new ImageIcon("image\\login\\注册按钮.png"));
    String codeStr = CodeUtil.getCode();
    JLabel rightCode = new JLabel(codeStr);

    // 既要用户输入，又要被获取判断
    JTextField userInput = new JTextField();
    JPasswordField pswInput = new JPasswordField();
    JTextField codeInput = new JTextField();


    public LoginJFrame(){

        // 初始化界面
        initFrame();

        // 添加界面中的各种内容
        initView();

        // 可视化
        this.setVisible(true);
    }

    // 添加界面中的各种内容
    private void initView() {

        // 设置“用户名”图片，位置和宽高
        JLabel userJlb = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        userJlb.setBounds(116, 135, 51, 19);
        this.getContentPane().add(userJlb);
        // 用户名输入框
        userInput.setBounds(195, 134, 200, 30);
        this.getContentPane().add(userInput);

        // 设置“密码”图片，位置和宽高
        JLabel pswJlb = new JLabel(new ImageIcon("image\\login\\密码.png"));
        pswJlb.setBounds(130,195, 35, 18);
        this.getContentPane().add(pswJlb);
        // 密码输入框
        pswInput.setBounds(195, 195, 200, 30);
        this.getContentPane().add(pswInput);

        // 设置“验证码”图片，位置和宽高
        JLabel vCodeJlb = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        vCodeJlb.setBounds(133, 256, 50, 30);
        this.getContentPane().add(vCodeJlb);
        // 验证码输入框
        codeInput.setBounds(195, 256, 100, 30);
        this.getContentPane().add(codeInput);

        // 验证码显示
        rightCode.setBounds(300, 256, 50, 30);
        this.getContentPane().add(rightCode);

        // 登录按钮
        logJbt.setBounds(123, 310, 128, 47);
        logJbt.setBorderPainted(false);
        logJbt.setContentAreaFilled(false);
        this.getContentPane().add(logJbt);

        // 注册按钮
        registerJbt.setBounds(256, 310, 128, 47);
        registerJbt.setBorderPainted(false);
        registerJbt.setContentAreaFilled(false);
        this.getContentPane().add(registerJbt);

        // 背景图片
        JLabel bg = new JLabel(new ImageIcon("image\\login\\background.png"));
        bg.setBounds(0, 0, 470, 390);
        this.getContentPane().add(bg);

        // 登录按钮监听并执行（点击、按下不松、松开）
        logJbt.addMouseListener(this);
        // 注册按钮监听并执行
        registerJbt.addMouseListener(this);
        // 验证码监听并执行（点击）
        rightCode.addMouseListener(this);
    }

    // 初始化界面
    private void initFrame() {

        // 设置界面宽高
        this.setSize(488, 430);
        // 设置界面标题
        this.setTitle("GameLogin v1.0");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认模式，使得组件按照xy来排列
        this.setLayout(null);

    }

    // 鼠标点击
    @Override
    public void mouseClicked(MouseEvent e) {

        // 获取点击对象
        Object source = e.getSource();

        if (source == registerJbt){

            // 关闭登录页面，跳转注册页面
            this.setVisible(false);
            new RegisterJFrame();

        } else if (source == logJbt) {

            // 验证用户名、密码、验证码，正确or不正确，跳转or不跳转
            String usernameInput = userInput.getText();
            String passwordInput = pswInput.getText();
            String CodeInput = codeInput.getText();

            // 验证码
            if(!CodeInput.equalsIgnoreCase(rightCode.getText())){

                // 提示验证码错误
                showJDialog("验证码错误，请重新输入！");

                // 更换验证码
                String newCode = CodeUtil.getCode();
                rightCode.setText(newCode);

                System.out.println("111111");

                // 验证码不通过，不再执行之后的检查
                return;
            }

            // 检查是否为空
            if (usernameInput.isEmpty() || passwordInput.isEmpty()){

                // 提示用户名或者密码为空
                showJDialog("用户名和密码不能为空！");
                // 为空，不再进行之后的检查
                return;
            }

            // 比较用户名和密码
            boolean result = checkUserInfo(list, usernameInput, passwordInput);

            if(!result){
                showJDialog("用户名或密码错误！");
            } else{
                // 关闭当前界面，打开游戏界面
                this.setVisible(false);
                new GameJFrame();
            }

        } else if (source == rightCode) {

            // 验证码更换
            String newCode = CodeUtil.getCode();
            rightCode.setText(newCode);
        }

    }

    // 鼠标按下不松
    @Override
    public void mousePressed(MouseEvent e) {

        // 获取监听对象
        Object source = e.getSource();

        if(source == registerJbt){

            // 注册按钮图片变化。先删除原来的？好像不用
            registerJbt.setIcon(new ImageIcon("image\\login\\注册按下.png"));

        } else if (source == logJbt) {

            // 登录按钮图片变化
            logJbt.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        }

    }

    // 鼠标松开
    @Override
    public void mouseReleased(MouseEvent e) {

        // 获取监听对象
        Object source = e.getSource();

        if(source == registerJbt){

            // 注册按钮图片变化
            registerJbt.setIcon(new ImageIcon("image\\login\\注册按钮.png"));

        } else if (source == logJbt) {

            // 登录按钮图片变化
            logJbt.setIcon(new ImageIcon("image\\login\\登录按钮.png"));

        }
    }

    // 鼠标划入
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入");
    }

    // 鼠标划出
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出");
    }

    // 弹窗
    public void showJDialog(String content){

        // 创建一个弹窗
        JDialog jDialog = new JDialog();
        // 创建一个容器放文字
        JLabel warning = new JLabel(content);
        // 设置位置和宽高
        warning.setBounds(0, 0, 200, 80);
        // 将容器添加进弹窗
        jDialog.getContentPane().add(warning);
        // 设置弹窗大小
        jDialog.setSize(240, 80);
        // 设置弹窗居中
        jDialog.setLocationRelativeTo(null);
        // 设置弹窗置顶
        jDialog.setAlwaysOnTop(true);
        // 弹窗不关闭无法进行其他操作
        jDialog.setModal(true);
        // 弹窗可视
        jDialog.setVisible(true);

    }

    //
    public boolean checkUserInfo(ArrayList<User> list, String usernameInput, String pswInput){

        for (int i = 0; i < list.size(); i++) {

            User u = list.get(i);
            String rightName = u.getUsername();
            String rightPsw = u.getPassword();

            if(usernameInput.equals(rightName) && pswInput.equals(rightPsw)){
                return true;
            }

        }
        return false;
    }
}