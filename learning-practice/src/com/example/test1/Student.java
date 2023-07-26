package com.example.test1;

public class Student{
    private String name;
    private int age;

//针对每一个私有化的成员变量，都需要get和set方法
//set:给成员变量赋值
//get:对外提供成员变量

    public void setName(String n){  //给name赋值
        name=n;
    }
    public String getName(){  //对外提供name属性
        return name;
    }

    public void setAge(int a){
        age = a;
    }
    public int getAge(){
        return age;
    }
}