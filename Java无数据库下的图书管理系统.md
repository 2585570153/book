---
title: Java无数据库下的图书管理系统
categories:
  - 代码学习
  - Java
tags:
  - Java
cover: >-
  https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-03-15%20211050.png
abbrlink: a51586d5
date: 2023-03-15 21:14:39
description:
---

# 前言

没有使用数据库，没有使用JDBC 单纯的拿列表开发的一个图书管理系统，主要目的在于练习java一些基础的知识，感兴趣的可以下载代码了解一下。

#  提醒

这个是基于列表的增删改查，列表是在运行的时候会保存数据，但是当程序结束后，一切有恢复原来的模样，在写这个最简单的图书管理系统，用的是简化版的三层架构，为了之后完善方便。

三层架构可以非常快速的将这个系统修改成使用数据库版本，达到真正的存储数据。

# 软件界面

![屏幕截图 2023-03-15 211050](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-03-15%20211050.png)

# 目录结构

### dao 数据层

- Book   存放图书属性
- ListBook  主要的列表存储功能都在这里

### service 业务层

- Create 新增图书

- Delete  删除图书

- Updata 修改图书

  ![image-20230316080700127](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316080700127.png)

###  vuew 视图层

- Index 欢迎界面

- Login  登录界面 账号admin 密码 123456

- Ui 主界面

  



# 代码

### Main.java

```java
package com;
import com.view.Index;
import com.view.Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author : ad
 **/
public class Main {
    public static void main(String[] args) {
        try {
            // 创建一个 FileReader 对象来读取文件
            FileReader reader = new FileReader("src\\banner.txt");

            // 创建一个 BufferedReader 对象来读取字符流
            BufferedReader bufferedReader = new BufferedReader(reader);

            // 读取文件内容并输出到控制台
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭文件流
            reader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Index index = new Index();
        System.out.println("用户名：");
        Scanner scanner = new Scanner(System.in);
        String name= scanner.next();
        System.out.println("密码：");
        String password = scanner.next();
        Login login = new Login(name,password);
        
    }
}
```

### Book.java

```java
package com.dao;

import java.util.Date;

public class Book {
    public Book(int id,String bookname, String author, String print, String date) {
        this.bookname = bookname;
        this.author = author;
        this.print = print;
        this.pubDate = date;
        this.id=id;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    private String bookname;
    private String author;
    private String print;
    private String pubDate;

    private int id;

    @Override
    public String toString() {
        return  "书名：《" + bookname +"》"+ "作者：" + author +  "出版社：" + print +  "出版日期" + pubDate;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrint(String print) {
        this.print = print;
    }



    public String getBookname() {
        return bookname;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrint() {
        return print;
    }


}

```

### Index.java

```java
package com.view;

public class Index {
     public Index(){

        System.out.println("*********************");
        System.out.println("**欢迎进入图书管理系统**");
        System.out.println("*********************");
        System.out.println("请输入用户名和密码进行登录");
    }
}

```

### Delete.java

```java
package com.service;

import com.dao.ListBook;

public class Delete {

    public Delete(int id) {
        ListBook.delete(id);

    }
}

```

### Ui.java

```java
package com.view;
import com.dao.ListBook;
import com.service.Create;
import com.service.Delete;
import com.service.Updata;

import java.util.Scanner;
/**
 * @author : ad
 **/

public class Ui  {
    public Ui() {
        System.out.println("************************************");
        System.out.println("***********图书管理系统主页面**********");
        System.out.println("*************以下为图书列表***********");
        System.out.println("************************************");
        ListBook.read();
        run();
    }
    public void run (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("********请选择你的命令进行控制操作*******");
        System.out.println("1.添加书籍 2.删除书籍 3.修改图书 4.退出程序");
        System.out.println("************************************");
        int i = Integer.parseInt(scanner.next());
        if(i==4){
            System.exit(0);
        }
        fun(i);
        }
    public void fun(int i){
        Scanner scanner = new Scanner(System.in);
        boolean t=true;
        while(t){
            switch (i){
                case 1:
                    System.out.println("************************************");
                    System.out.println("请输入书名");
                    String bookname = scanner.next();
                    System.out.println("请输入作者");
                    String author = scanner.next();
                    System.out.println("请输入出版社");
                    String print = scanner.next();
                    System.out.println("请输入出版日期");
                    String date = scanner.next();
                    System.out.println("************************************");
                    new Create(bookname,author,print,date);
                    run();
                    break;
                case 2:
                    System.out.println("************************************");
                    System.out.println("*******请输入你删除哪一行书籍**********");
                    System.out.println("********退出删除书籍功能请按e**********");
                    System.out.println("************************************");
                    String intid = scanner.next();
                    String temp = "e";
                    if (!intid.equals(temp)){
                        int id= Integer.parseInt(intid);
                        new Delete(id);
                    }else {
                        t=false;
                        run();
                    }
                    break;
                case 3:
                    System.out.println("************************************");
                    System.out.println("*******请输入你修改哪一行书籍**********");
                    System.out.println("********退出修改书籍功能请按p**********");
                    System.out.println("************************************");
                    String upid2 = scanner.next();
                    String temp2 = "p";
                    if (!upid2.equals(temp2)){
                        int upid= Integer.parseInt(upid2);
                        System.out.println("************************************");
                        System.out.println("********请选择你的命令进行控制操作*******");
                        System.out.println("1.修改书名 2.修改作者 3.修改出版社 4.修改出版日期");
                        System.out.println("************************************");
                        String temp3 = scanner.next();
                        int temp4= Integer.parseInt(temp3);
                        switch (temp4){
                            case 1:
                System.out.println("请输入修改书名");
                                String upbookname = scanner.next();
                                Updata.upbookname(upid,upbookname);
                                run();
                                break;
                            case 2:
                                System.out.println("请输入修改作者");
                                String updauthor = scanner.next();
                                Updata.updauthor(upid,updauthor);
                                run();
                                break;
                            case 3:
                                System.out.println("请输入修改出版社名字");
                                String upprint = scanner.next();
                                Updata.upprint(upid,upprint);
                                run();
                                break;
                            case 4:
                                System.out.println("请输入修改出版社日期");
                                String updata = scanner.next();
                                Updata.updata(upid,updata);
                                run();
                                break;

                        }


                    }else {
                        t=false;
                        run();
                    }
                    break;
            }
        }
    }

    }






```

### Login.java

```java
package com.view;

public class Login {
    String name;
    String password;

    public Login(String name, String password) {
        this.name = name;
        this.password = password;
        log();
    }
    public void log(){
        String loginname = "admin";
        String loginpassword = "123456";

        if (name.equals(loginname) && password.equals(loginpassword)){
            System.out.println("登陆成功，欢迎"+name+"使用本系统");
            Ui ui =new Ui();
        }else {
            System.out.println("账号密码错误");
        }
    }


}

```

### Updata.java

```java
package com.service;

import com.dao.ListBook;

/**
 * @author : ad
 **/
public class Updata {
    public static void upbookname(int id,String upbookname){
        ListBook.upbookname(id, upbookname);
    }
    public static void updauthor(int id,String upauthor){
        ListBook.upauthor(id, upauthor);

    }
    public static void upprint(int id,String upprint){
        ListBook.upprint(id, upprint);

    }
    public static void updata(int id,String updata){
        ListBook.updata(id, updata);
    }
}

```

### ListBook.java

```java
package com.dao;

import java.util.ArrayList;
/**
 * @author : ad
 **/

public class ListBook {
    static ArrayList<Book> listbook = new ArrayList<Book>();

    public static void read() {
        Book book1 = new Book(1,"Java编程思想", "Bruce Eckel", "机械工业出版社", "2007年9月");
        Book book2 = new Book(2,"深入浅出MySQL", "杨志刚", "电子工业出版社", "2018年1月");
        Book book3 = new Book(3,"计算机网络自顶向下方法", "James F.Kurose", "机械工业出版社", "2007年9月");
        Book book4 = new Book(4,"算法导论", "Thomas H.Cormen", "机械工业出版社", "2007年9月");
        Book book5 = new Book(5,"高性能MySQL", "Bruce Eckel", "电子工业出版社", "2007年9月");

        listbook.add(book1);
        listbook.add(book2);
        listbook.add(book3);
        listbook.add(book4);
        listbook.add(book5);
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    public static void delete(int i){
        if(i-1<=listbook.size()){
            listbook.remove(i-1);
            System.out.println("删除成功");
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }else {
            System.out.println("删除失败");
        }
    }
    public static void create(String bookname, String author, String print, String date){
        listbook.add(new Book(1+listbook.size(),bookname, author, print, date));
        System.out.println("添加成功");
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }

    public static void upauthor(int id,String upauthor){
        Book upbook=listbook.get(id-1);
        upbook.setAuthor(upauthor);
        listbook.set(id-1,upbook);
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    public static void upprint(int id,String upprint){
        Book upbook=listbook.get(id-1);
        upbook.setPrint(upprint);
        listbook.set(id-1,upbook);
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    public static void updata(int id,String updata){
        Book upbook=listbook.get(id-1);
        upbook.setPubDate(updata);
        listbook.set(id-1,upbook);
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    public static void upbookname(int id,String upbookname){
        Book upbook=listbook.get(id-1);
        upbook.setBookname(upbookname);
        listbook.set(id-1,upbook);
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }

}
```



# 截图演示

![image-20230316081712238](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316081712238.png)

![image-20230316081805118](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316081805118.png)

![image-20230316081849175](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316081849175.png)

# 2023.3.16更新

1.本次更新加入了日志记录，可以查询用户干了什么，以及图书最重要的功能 借书和还书，以及修复了一些bug；

![image-20230316194604495](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316194604495.png)

2.新增加的类

- Listlog.java
- Log.java
- Inbook.java
- Outbook.java

3.增加了数字验证，输入字符串的时候不会导致程序终止。

