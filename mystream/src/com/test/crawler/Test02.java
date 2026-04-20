package com.test.crawler;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test02 {

    static void main(String[] args) throws IOException {

        // 1. 定义变量记录网址
        String familyUrl = "https://hanyu.baidu.com/shici/detail?from=aladdin&pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&smp_names=termBrand2%2Cpoem1";
        String girlUrl = "https://baijiahao.baidu.com/s?id=1607838443555118793&wfr=spider&for=pc";
        String boyUrl = "https://www.hmz8.com/qiming/qiming6/5549.html";

        // 2. 链接网址，获取网页原数据
        String familyNameStr = webCrawler(familyUrl);
        String girlNameStr = webCrawler(girlUrl);
        String boyNameStr = webCrawler(boyUrl);

        // 3. 利用正则表达式，获取网页原数据中需要的部分，放进list容器
        ArrayList<String> familyNameListTemp = getData(familyNameStr, "([\\u4E00-\\u9FA5]{4})(，|。)", 1);
        ArrayList<String> girlNameListTemp = getData(girlNameStr, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        ArrayList<String> boyNameListTemp = getData(boyNameStr, "(\\d+、)([\\u4E00-\\u9FA5]{2})：", 2);

        // 4. 根据不同数据通过不同转换成为纯粹的姓氏/名字，存放进list容器

        // (1) 姓氏 [赵, 钱, 孙, 李] 形式
        ArrayList<String> familyNameList = new ArrayList<>();

        for(String str : familyNameListTemp){

            for (int i = 0; i < 4; i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");
            }
        }

        // (2) 女生名字 [零瀛, 玉祁, 伊懦] 形式
        ArrayList<String> girlNameList = new ArrayList<>();

        for(String str : girlNameListTemp){

            if(!girlNameList.contains(str)){
                girlNameList.add(str);
            }
        }

        // (3) 男生名字 [经行, 知程, 凌霄] 形式
        ArrayList<String> boyNameList = new ArrayList<>();

        for(String str : boyNameListTemp){

            if(!boyNameList.contains(str)){
                boyNameList.add(str);
            }
        }

        // 5. 转换成 姓名-性别-年龄 形式，并存放进入最终的人员信息集合
        ArrayList<String> list = listInfos(familyNameList, girlNameList, boyNameList, 100, 100);

        // 6. 将人员信息写入本地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("infos.txt"));

        for(String str : list){
            bw.write(str);
            bw.newLine();
        }

        bw.close();
    }

    // 转换成 姓名-性别-年龄 形式，并存放进入最终的人员信息集合
    public static ArrayList<String> listInfos(ArrayList<String> familyNameList, ArrayList<String> girlNameList, ArrayList<String> boyNameList, int girlCounts, int boyCounts){

        // 1. 创建集合来存放人员信息
        ArrayList<String> list = new ArrayList<>();

        // 2. 随机数生成年龄
        Random r = new Random();

        // 3. 生成完整信息并存入

        // (1) 女生
        HashSet<String> girlHs = new HashSet<>();

        while(true){

            // HashMap已满，则跳出循环，不再添加人员
            if(girlHs.size() == girlCounts) break;

            // 打乱姓氏与名字顺序
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);

            girlHs.add(familyNameList.getFirst() + girlNameList.getFirst());
        }

        for(String girlName : girlHs){
            // 18 ~ 24
            int age = r.nextInt(7) + 18;
            list.add(girlName + "-女-" + age);
        }

        // (2) 男生
        HashSet<String> boyHs = new HashSet<>();

        while(true){

            if(boyHs.size() == boyCounts){
                break;
            }

            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);

            boyHs.add(familyNameList.get(0) + boyNameList.get(0));
        }

        for(String boyName : boyHs){
            // 18 ~ 25
            int age = r.nextInt(8) + 18;
            list.add(boyName + "-男-" + age);
        }

        // 打乱list集合
        Collections.shuffle(list);

        return list;
    }

    // 利用正则表达式，获取网页原数据中需要的部分，放进 list 容器
    public static ArrayList<String> getData(String str, String regex, int index){

        // 创建list容器
        ArrayList<String> list = new ArrayList<>();

        // 编译正则表达式，生成 Pattern 对象
        Pattern pattern = Pattern.compile(regex);

        // 创建匹配器，将规则应用于目标文本
        Matcher matcher = pattern.matcher(str);

        // 尝试查找下一个匹配的子序列，若成功则更新内部游标状态并返回 true
        while(matcher.find()){

            // 获取当前匹配到的完整子序列，添加进list
            String group = matcher.group(index);
            list.add(group);
        }

        return list;
    }

    // 链接网址，获取网页原数据
    public static String webCrawler(String net) throws IOException {

        // 1. 创建 StringBuilder 对象，存放网页原数据
        StringBuilder sb = new StringBuilder();

        // 2. 创建 URL 对象，链接网址，传入网页数据

        // 把字符串解析成一个计算机能理解的地址对象，明确协议、主机和端口等信息
        URL url = new URL(net);

        // Java和远程服务器进行握手，建立连接通道
        URLConnection urlConnection = url.openConnection();

        // 获取字节输入流
        InputStream inputStream = urlConnection.getInputStream();

        // 按照 UTF-8 编码将字节流转换成字符流
        InputStreamReader isr = new InputStreamReader(inputStream, Charset.forName("UTF-8"));

        // 利用 BufferedReader 逐行读取以及缓冲区
        BufferedReader br = new BufferedReader(isr);

        String line;
        while((line = br.readLine()) != null){
            // 存放进入sb容器
            sb.append(line).append("\n");
        }

        br.close();

        return sb.toString();
    }
}