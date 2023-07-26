package com.example.StudentManagerSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args){
        ArrayList<Student> list = new ArrayList<>();
        label1:while(true){
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("1:添加");
            System.out.println("2:删除");
            System.out.println("3:修改");
            System.out.println("4:查询");
            System.out.println("5:退出");
            System.out.println("请输入您的选择");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch (choose){
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> amendStudent(list);
                case "4" -> inquireStudent(list);
                case "5" -> {System.out.println("退出: ");break label1;}//退出while循环
                default  -> System.out.println("没有这个选项");
            }
        }


    }
    //添加学生
    public static void addStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();
        String id = null;
        while(true){
            System.out.println("请输入学生id：");
            id = sc.next();
            boolean b = judge(list,id);
            if(b){
                System.out.println("id已经存在，请重新输入");
            }else{
                s1.setId(id);//输入的id不存在，录入成功
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        s1.setName(name);
        System.out.println("请输入学生年龄：");
        int age = sc.nextInt();
        s1.setAge(age);
        System.out.println("请输入学生家庭地址：");
        String address = sc.next();
        s1.setAddress(address);
        list.add(s1);
        System.out.println("学生信息添加成功");
    }
    //删除学生
    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("请输入要删除的学生id");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list,id);
        boolean b = judge(list,id);
            if(b){
                list.remove(index);//id存在，删除
                System.out.println("成功删除学生信息");
            }else{
                System.out.println("id不存在，返回主菜单");
            }
        }
    //修改学生
    public static void amendStudent(ArrayList<Student> list){
        System.out.println("请输入需要修改的学生id");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list,id);
        if(index == -1){
            System.out.println("要修改的"+id+"不存在，返回主菜单");
            return;
        }else{
            Student s = list.get(index);
            System.out.println("请输入修改后的姓名：");
            String newName = sc.next();
            s.setName(newName);
            System.out.println("请输入修改后的年龄：");
            int newAge = sc.nextInt();
            s.setAge(newAge);
            System.out.println("请输入修改后的地址：");
            String newAddress = sc.next();
            s.setAddress(newAddress);
            list.set(index,s);
            System.out.println("信息修改成功");
        }
    }
    //查询学生
    public static void inquireStudent(ArrayList<Student> list){
        if(list.size() == 0){
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + " \t" + s.getAge() + "\t" + s.getAddress());
        }
    }
    //运用布尔类型的方法判断学生id在集合中是否存在
    public static Boolean judge(ArrayList<Student> list,String id){
       /* for (int i = 0; i < list.size(); i++) {
            Student s2 = list.get(i);
            String id1 = s2.getId();
            if(id1.equals(id)){
                return true;
            }
        }
        return false;*/
        return getIndex(list,id) >= 0;
    }
    //利用索引的方法判断id是否存在
    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Student s2 = list.get(i);
            String id1 = s2.getId();
            if(id1.equals(id)){
                return i;
            }
        }
        return -1;
    }
}
