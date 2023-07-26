package com.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //创建File类对象，这只会在内存中创建一个File类型的对象，并不会创建一个真实存在的a.text文件，所以先创建一个文件a.text
        File file = new File("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\file\\a.text");
        System.out.println(file.length());
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());


        file = new File("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\file\\b.text");
        //如果指定创建文件的路径不对，会抛出异常IOException
        System.out.println(file.createNewFile());

        file = new File("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\file\\m");
        //创建之前不存在的单层文件夹m
        System.out.println(file.mkdir());

        file = new File("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\file\\a\\b\\c");
        //创建之前不存在的多层文件夹\a\b\c
        System.out.println(file.mkdirs());
        //删除文件夹c
        System.out.println(file.delete());

        file = new File("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\file\\a");
        //false，删除文件夹a失败，因为a不为空
        System.out.println(file.delete());

        file = new File("D:\\IDEA\\IntelliJ IDEA Community Edition 2023.1\\Config\\project1\\src\\com\\file\\b.text");
        //删除文件b.text
        System.out.println(file.delete());
    }
}
