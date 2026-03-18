package com.example.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    // 定义一个二维数组
    int[][] date = new int[4][4];

    // 记录0的坐标
    int x;
    int y;

    // 定义一个路径
    String path = "image\\animal\\animal1\\";

    // 定义胜利的数组
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 定义计数器
    int step = 0;

    // 一来为数据初始化生成随机数，二来随机出现动物/美女/运动图片
    Random r = new Random();

    // 重新游戏JMenuItem
    JMenuItem replayItem = new JMenuItem("重新游戏");
    // 重新登录JMenuItem
    JMenuItem relogItem = new JMenuItem("重新登录");
    // 关闭游戏JMenuItem
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    // 微信号JMenuItem
    JMenuItem accountItem = new JMenuItem("微信号");
    // 美女Item
    JMenuItem girlItem = new JMenuItem("美女");
    // 动物Item
    JMenuItem animalItem = new JMenuItem("动物");
    // 运动Item
    JMenuItem sportItem = new JMenuItem("运动");

    public GameJFrame() {

        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenu();

        // 初始化数据(打乱)
        initDate();

        //初始化图片(根据打乱后的结果加载图片)
        initImage();

        // 可视化
        this.setVisible(true);
    }

    // 初始化数据(打乱)
    private void initDate() {

        // 定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        // 打乱数组顺序
        for (int i = 0; i < tempArr.length; i++) {

            // 生成一个随机数
            int index = r.nextInt(tempArr.length);

            // 遍历，换数
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        // 把一维数组的数放入二维数组
        for (int i = 0; i < tempArr.length; i++) {

            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }

            date[i / 4][i % 4] = tempArr[i];
        }
    }

    // 初始化图片
    private void initImage() {

        // 删除已经出现的所有的图片
        this.getContentPane().removeAll();

        // 如果胜利，显示胜利图标
        if(isVictory()){

            JLabel winJLabel = new JLabel(new ImageIcon("image\\win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                // 获取数组数字
                int num = date[i][j];
                // 创建图片对象，jLabel管理图片
                JLabel jLabel1 = new JLabel(new ImageIcon(path + num + ".jpg"));
                // 设置图片位置
                jLabel1.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                // 给图片添加边框
                jLabel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // 容器添加到界面中
                this.getContentPane().add(jLabel1);
            }
        }

        // 背景图片，先加载的图片再上方
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel jLabel2 = new JLabel(bg);
        jLabel2.setBounds(40, 40, 508, 560);
        this.getContentPane().add(jLabel2);

        // 计数器显示
        JLabel stepJLabel = new JLabel("步数：" + step);
        stepJLabel.setBounds(50, 25, 100, 50);
        this.getContentPane().add(stepJLabel);

        // 刷新界面
        this.getContentPane().repaint();

    }

    // 初始化菜单
    private void initJMenu() {
        // JMenuBar
        JMenuBar jMenuBar = new JMenuBar();

        // 功能JMenu
        JMenu functionJMenu = new JMenu("功能");
        // 关于我们JMenu
        JMenu aboutusJMenu = new JMenu("关于作者");
        // 更换图片JMenu
        JMenu changeImgJMenu = new JMenu("更换图片");

        // 将更换图片JMenu放入功能JMenu
        functionJMenu.add(changeImgJMenu);

        // 将JMenuItem放进JMenu
        functionJMenu.add(replayItem);
        functionJMenu.add(relogItem);
        functionJMenu.add(closeItem);
        aboutusJMenu.add(accountItem);

        changeImgJMenu.add(girlItem);
        changeImgJMenu.add(animalItem);
        changeImgJMenu.add(sportItem);

        // 将JMenu放进JMenuBar
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutusJMenu);

        // 添加监听
        replayItem.addActionListener(this);
        relogItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);

        // 将JMenuBar放进GameJFrame
        this.setJMenuBar(jMenuBar);
    }

    // 初始化界面
    private void initJFrame() {
        // 设置界面宽高
        this.setSize(603, 680);
        // 设置界面标题
        this.setTitle("JigsawGame v1.0");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中位置，是的组件按照xy放置
        this.setLayout(null);

        // 给整个界面添加键盘监听
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 键盘按下不松时
    @Override
    public void keyPressed(KeyEvent e) {

        // 按下不松时查看完整图片
        int keyCode = e.getKeyCode();
        if (keyCode == 65) {

            // 首先清空原本的图片
            this.getContentPane().removeAll();
            // 然后放上完整图片
            ImageIcon all = new ImageIcon(path + "all.jpg");
            JLabel jLabel = new JLabel(all);
            jLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(jLabel);

            // 背景图片，先加载的图片再上方
            ImageIcon bg = new ImageIcon("image\\background.png");
            JLabel jLabel2 = new JLabel(bg);
            jLabel2.setBounds(40, 40, 508, 560);
            this.getContentPane().add(jLabel2);

            this.getContentPane().repaint();
        }

    }

    // 键盘松开时
    @Override
    public void keyReleased(KeyEvent e) {
        
        // 先判断是否胜利，如果胜利结束游戏，否则继续判断
        if(isVictory()){
            return;
        }

        int keyCode = e.getKeyCode();
        // 上下左右移动逻辑，首先定位0

        if (keyCode == 37) {
            // 边界情况
            if (y == 3) {
                return;
            }
            // 向左移动
            date[x][y] = date[x][y + 1];
            date[x][y + 1] = 0;
            y++;
            // 每移动一步，计数器加一
            step++;

            // 调用方法按照新数字顺序放图片
            initImage();

        } else if (keyCode == 38) {
            // 边界情况
            if (x == 3) {
                return;
            }
            // 向上移动
            date[x][y] = date[x + 1][y];
            date[x + 1][y] = 0;
            x++;
            // 每移动一步，计数器加一
            step++;

            // 调用方法按照新数字顺序放图片
            initImage();

        } else if (keyCode == 39) {
            // 边界情况
            if (y == 0) {
                return;
            }
            // 向右移动
            date[x][y] = date[x][y - 1];
            date[x][y - 1] = 0;
            y--;
            // 每移动一步，计数器加一
            step++;

            // 调用方法按照新数字顺序放图片
            initImage();

        } else if (keyCode == 40) {
            // 边界情况
            if (x == 0) {
                return;
            }
            // 向下移动
            date[x][y] = date[x - 1][y];
            date[x - 1][y] = 0;
            x--;
            // 每移动一步，计数器加一
            step++;

            // 调用方法按照新数字顺序放图片
            initImage();

        } else if (keyCode == 65) {
            // 还原原本拼图
            initImage();
            
        } else if (keyCode== 87) {
            // 作弊码，按w键自动复原
            date = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();

        }
    }

    // 判断拼图是否胜利
    private boolean isVictory() {
        for (int i = 0; i < date.length; i++) {

            for (int j = 0; j < date[i].length; j++) {
                // 有不相同，返回false
                if(date[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        // 循环完毕，返回true
        return true;
    }

    // 动作监听，鼠标点击事件时
    @Override
    public void actionPerformed(ActionEvent e) {

        // 获取点击的对象
        Object source = e.getSource();

        // 重新游戏
        if(source == replayItem){

            // 计数器清零
            step = 0;
            // 重新打乱数据
            initDate();
            // 重新加载图片
            initImage();

        } else if (source == relogItem) {
            // 重新登录

            // 关闭游戏界面?
            this.setVisible(false);
            // 显示登录界面
            new LoginJFrame();

        } else if (source == closeItem) {
            // 关闭游戏

            // 关闭虚拟机，结束程序
            System.exit(0);

        } else if (source == accountItem) {
            // 显示微信二维码

            // 新建一个弹窗
            JDialog jDialog = new JDialog();

            // 新建一个管理容器放置图片
            JLabel account = new JLabel(new ImageIcon("image\\about.png"));
            account.setBounds(0, 0, 258, 258);
            // 把图片添加到容器中
            jDialog.getContentPane().add(account);
            // 设置容器的位置和宽高
            jDialog.setSize(344, 344);
            // 设置容器居中
            jDialog.setLocationRelativeTo(null);
            // 设置容器在最上方
            jDialog.setAlwaysOnTop(true);
            // 设置不关闭容器就无法操作其他
            jDialog.setModal(true);
            // 设置容器可视
            jDialog.setVisible(true);

        } else if (source == girlItem) {

            // 更换为美女拼图
            int index = r.nextInt(13) + 1;
            // 路径 随机选择美女
            path = "image\\girl\\girl" + index + "\\";

            // 计数器清零
            step = 0;
            // 打乱数据
            initDate();
            // 由乱的数据呈现图片
            initImage();

        }else if (source == animalItem) {

            // 更换为动物拼图
            int index = r.nextInt(8) + 1;
            // 路径 随机选择动物
            path = "image\\animal\\animal" + index + "\\";

            // 计数器清零
            step = 0;
            // 打乱数据
            initDate();
            // 由乱的数据呈现图片
            initImage();

        }else if (source == sportItem) {

            // 更换为运动拼图
            int index = r.nextInt(10) + 1;
            // 路径 随机选择运动
            path = "image\\sport\\sport" + index + "\\";

            // 计数器清零
            step = 0;
            // 打乱数据
            initDate();
            // 由乱的数据呈现图片
            initImage();

        }
    }

}