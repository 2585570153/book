# java无数据库的图书管理系统
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
# 截图演示

![image-20230316081712238](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316081712238.png)

![image-20230316081805118](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316081805118.png)

![image-20230316081849175](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316081849175.png)

# 视频演示

[哔哩哔哩](https://www.bilibili.com/video/BV1zM4y1z78Y/)

# 2023.3.16更新

1.本次更新加入了日志记录，可以查询用户干了什么，以及图书最重要的功能 借书和还书，以及修复了一些bug；

![image-20230316194604495](https://syb-1303019251.cos.ap-beijing.myqcloud.com/md/image-20230316194604495.png)

2.新增加的类

- Listlog.java
- Log.java
- Inbook.java
- Outbook.java

3.增加了数字验证，输入字符串的时候不会导致程序终止。

4.增加了图书重名验证

# 2023.3.17 更新

1.修复登录错误程序结束。

2.增加逻辑判断

- 在图书外借的时候不能下架书籍。
- 已经拥有的图书，不能再继续添加
- 增强程序的健壮性
