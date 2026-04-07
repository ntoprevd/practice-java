package com.test.crawler;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    static void main(String[] args) throws IOException {

        // 1. 定义变量记录网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d";
        String boyNameNet = "https://qiming.hao86.com/view/26491/";
        String girlNameNet = "https://xuminhao.com/mz/20751.html";

        // 2. 获取网址所有数据
        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        // 3. 正则表达式获取需要的数据部分
        ArrayList<String> familyListTemp = getData(familyNameStr, "([\\u4E00-\\u9FA5]{4})(，|。)", 1);
        ArrayList<String> boyListTemp = getData(boyNameStr, "(\\d{1,3}、)([\\u4E00-\\u9FA5]{2})", 2);
        ArrayList<String> girlListTemp = getData(girlNameStr, "([\\u4E00-\\u9FA5]{2})(、| )", 1);

        // 4. 创建集合存放姓氏、名字

        // 姓氏
        ArrayList<String> familyNameList = new ArrayList<>();

        for (String str : familyListTemp){

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                familyNameList.add(c + "");
            }
        }

        // 男生名字 去重
        ArrayList<String> boyNameList = new ArrayList<>();

        for (String str : boyListTemp){

            if(!boyNameList.contains(str)){
                boyNameList.add(str);
            }
        }

        // 女生名字 去重
        ArrayList<String> girlNameList = new ArrayList<>();

        for(String str : girlListTemp){

            if(!girlNameList.contains(str)){
                girlNameList.add(str);
            }
        }

        // 5. 数据格式改为 姓名-性别-年龄，存放在集合中
        ArrayList<String> list = getInfos(familyNameList, boyNameList, girlNameList, 50, 50);

        // 6. 写入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("names.txt"));
        for(String info : list){

            bw.write(info);
            bw.newLine();
        }

        bw.close();
    }

    // 数据格式改为 姓名-性别-年龄，存放在集合中
    public static ArrayList<String> getInfos(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCounts, int girlCounts){

        // 生成男生不重复名字
        HashSet<String> boyHs = new HashSet<>();

        while(true){

            if(boyHs.size() == boyCounts){
                break;
            }

            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);

            boyHs.add(familyNameList.get(0) + boyNameList.get(0));
        }

        // 生成女生不重复名字
        HashSet<String> girlHs = new HashSet<>();

        while(true){

            if(girlHs.size() == girlCounts){
                break;
            }

            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);

            girlHs.add(familyNameList.get(0) + girlNameList.get(0));
        }

        // 格式修正
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();

        for(String boyName : boyHs){
            // 18 ~ 35
            int age = r.nextInt(18) + 18;
            list.add(boyName + "-男-" + age);
        }

        for(String girlName : girlHs){
            // 18 ~ 30
            int age = r.nextInt(13) + 18;
            list.add(girlName + "-女-" + age);
        }

        Collections.shuffle(list);

        return list;
    }

    // 获取网址中需要的数据
    public static String webCrawler(String net) throws IOException {

        // 1. 创建StringBuilder对象存放
        StringBuilder sb = new StringBuilder();

        // 2. 连接上网址
        URL url = new URL(net);
        URLConnection urlConnection = url.openConnection();

        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), Charset.forName("UTF-8"));

        BufferedReader br = new BufferedReader(isr);

        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }

    // 正则表达式获取需要的数据部分
    public static ArrayList<String> getData(String nameStr, String regex, int index) {

        // 创建list集合存放
        ArrayList<String> list = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameStr);

        while (matcher.find()) {

            String group = matcher.group(index);
            list.add(group);
        }

        return list;
    }
}
