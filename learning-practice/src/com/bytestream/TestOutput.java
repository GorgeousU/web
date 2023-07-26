package com.bytestream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutput {
    public static void main(String[] args){
        method1();
    }
    public static void method1(){
        OutputStream out = null;
        try{          //高效字节输出流BufferedOutputStream()
            out = new BufferedOutputStream(new FileOutputStream("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\bytestream\\t.text"));
            out.write(97);//ASCII中的a的值,write()写出操作
            out.write(98);//b
            out.write(99);//c
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(out != null){
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
