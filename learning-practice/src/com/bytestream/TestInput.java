package com.bytestream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInput {
    public static void main(String[] args){
        method1();
    }
    public static void method1(){ //字节流的读取
        InputStream in = null;//创建字节输入流的对象，并初始化
        try{                                       //文件t.text的绝对路径
            in = new BufferedInputStream(new FileInputStream("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\bytestream\\t.text"));
            int a;
            while((a = in.read()) != -1){ //read()每次调用都会读取一个字节，如果读到数据末尾，则返回-1
                System.out.print(a+" ");
            }
        }catch(Exception e){
            e.printStackTrace();//打印错误信息
        }finally { //finally内的内容一定会被执行
            try{
                if(in != null){  //单独写in.close()会提示可能会有NullPointerException，所以用if(in != null)包裹
                    in.close();//释放资源，流资源用完必须释放，所以放在finally里面
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
