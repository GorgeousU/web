package com.charstream;


import java.io.IOException;
import java.io.FileReader;

public class TestReader {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建流对象
        FileReader fr = new FileReader("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\charstream\\read.text");
        //定义变量，保留有效字符
        int len;
        //定义字符数组，用于保存文件read.text内的内容
        char[] cbuf = new char[2];
        while((len = fr.read(cbuf)) != -1){
            System.out.print(new String(cbuf,0,len));
        }
        //关闭资源
        fr.close();
    }
}
