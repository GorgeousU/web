package com.example.test1;

public class StudentTest {
    public static void main(String[] args){
        Student s = new Student();
        s.setName("luo");//赋值
        s.setAge(21);

        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
