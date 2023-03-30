package com.dao;

import java.util.ArrayList;
/**
 * @author : ad
 **/

public class ListBook {
    static ArrayList<Book> listbook = new ArrayList<Book>();

    public static void read() {
        Book book1 = new Book(1,"Java思想", "Bruce", "机械工业出版社", "2007年9月","充足",0);
        Book book2 = new Book(2,"Java放弃", "杨志刚", "电子工业出版社", "2018年1月","充足",0);
        Book book3 = new Book(3,"计算机网络", "James", "机械工业出版社", "2008年9月","充足",0);
        Book book4 = new Book(4,"算法导论", "Thomas", "机械工业出版社", "2009年9月","充足",0);
        Book book5 = new Book(5,"java", "Eckel", "电子工业出版社", "2010年9月","充足",0);

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
    public static void forbook(){
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
    // 删除
    public static void delete(int i){
        if(i-1<=listbook.size()){
            Book deletebook =listbook.get(i-1);
            String temp="不足";
            if (!temp.equals(deletebook.getState())){
                Listlog.delete(deletebook.getBookname());
                listbook.remove(i-1);
                System.out.println("删除成功");
                for (int j= 0;j<listbook.size();j++){
                    Book book = listbook.get(j);
                    book.setId(j+1);
                }
                for (Book book : listbook) {
                    String string = book.toString();
                    System.out.println(string);
                }
            }else {
                System.out.println("删除失败,本书没有归还");
            }

        }else {
            System.out.println("删除失败");
        }
    }
    // 添加
    public static void create(String bookname, String author, String print, String date,String state,int count) {
        int temp = 0;
        for (Book book : listbook) {
            String string = book.getBookname();
            if (string.equals(bookname)) {
                System.out.println("图书中已有本书，不需要再添加");
                temp = 1;
            }
        }
        if (temp == 0) {
            listbook.add(new Book(1 + listbook.size(), bookname, author, print, date, state, count));
            System.out.println("添加成功");
            for (Book book1 : listbook) {
                String string1 = book1.toString();
                System.out.println(string1);
            }

        }
    }

//修改图书
        public static void upauthor ( int id, String upauthor){
            Book upbook = listbook.get(id - 1);
            upbook.setAuthor(upauthor);
            listbook.set(id - 1, upbook);
            System.out.println("修改成功");
            Book deletebook = listbook.get(id - 1);
            Listlog.updata(deletebook.getBookname());
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }
        //修改图书
        public static void upprint ( int id, String upprint){
            Book upbook = listbook.get(id - 1);
            upbook.setPrint(upprint);
            listbook.set(id - 1, upbook);
            System.out.println("修改成功");
            Book deletebook = listbook.get(id - 1);
            Listlog.updata(deletebook.getBookname());
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }
        //修改图书
        public static void updata ( int id, String updata){
            Book upbook = listbook.get(id - 1);
            upbook.setPubDate(updata);
            listbook.set(id - 1, upbook);
            System.out.println("修改成功");
            Book deletebook = listbook.get(id - 1);
            Listlog.updata(deletebook.getBookname());
            for (Book book : listbook) {
                String string = book.toString();
                System.out.println(string);
            }
        }

    //修改图书
    public static void upbookname(int id,String upbookname){
        Book upbook=listbook.get(id-1);
        upbook.setBookname(upbookname);
        listbook.set(id-1,upbook);
        System.out.println("修改成功");
        Book deletebook =listbook.get(id-1);
        Listlog.updata(deletebook.getBookname());
        for (Book book : listbook) {
            String string = book.toString();
            System.out.println(string);
        }
    }
        public static void ifoutbook(String outbookname){
            for (int i=0;i<=listbook.size();i++) {
                if (i == listbook.size()){
                    System.out.println("查询失败，请重新输入");
                    break;
                }
                Book ifoutbook =listbook.get(i);
                String name =ifoutbook.getBookname();
                if (name.equals(outbookname)){
                    outbook(ifoutbook.getId());
                    break;
                }

            }

        }
    public static void outbook(int id){
        Book outbook=listbook.get(id-1);
        String temp = "不足";
        if(!temp.equals(outbook.getState())){
            outbook.setState(temp);
            outbook.setCount(1);
            listbook.set(id-1,outbook);
            System.out.println("借书成功，记得按时归还");
            Book deletebook =listbook.get(id-1);
            Listlog.outbook(deletebook.getBookname());
        }else{
            System.out.println("当前书籍库存不足，无法借出");
        }
    }
    public static void ifinbook(String inbookname){
        for (int i=0;i<=listbook.size();i++) {
            if (i == listbook.size()){
                System.out.println("没有查到这本书，请重新输入");
                break;
            }
            Book ifinbook =listbook.get(i);
            String name =ifinbook.getBookname();
            if (name.equals(inbookname)){
                inbook(ifinbook.getId());
                break;
            }

        }

    }
    public static void inbook(int id){
        Book outbook=listbook.get(id-1);
        String temp = "不足";
        String temp2 = "充足";
        if(temp.equals(outbook.getState())){
            outbook.setState(temp2);
            listbook.set(id-1,outbook);
            System.out.println("还书成功，欢迎下次光临");
            Book deletebook =listbook.get(id-1);
            Listlog.inbook(deletebook.getBookname());//日志记录
        }else{
            System.out.println("当前书籍库存充足，检查书名是否输入正确");
        }
    }
    public static int size(){
        return listbook.size();
    }
}