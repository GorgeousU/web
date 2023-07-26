package com.charstream;

import java.io.FileWriter;
import java.io.IOException;

public class TestWriter {
    public static void main(String[] args) throws IOException {
        //创建流对象
        FileWriter fw = new FileWriter("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\charstream\\read.text");
        char[] chars = "蜜雪冰城".toCharArray();
        fw.write(chars);//写出内容为 蜜雪冰城
        fw.write(chars,2,2);//从索引2开始，2个字节，则写出内容是 冰城
        fw.close();
    }
}
