package com.view;

import java.util.Scanner;

public class Index {
     public Index(){

        System.out.println("*********************");
        System.out.println("**欢迎进入图书管理系统**");
        System.out.println("*********************");
        System.out.println("请输入用户名和密码进行登录");
        run();
    }
    public static void run(){
        System.out.println("用户名：");
        Scanner scanner = new Scanner(System.in);
        String name= scanner.next();
        System.out.println("密码：");
        String password = scanner.next();
        Login login = new Login(name,password);
    }
}
