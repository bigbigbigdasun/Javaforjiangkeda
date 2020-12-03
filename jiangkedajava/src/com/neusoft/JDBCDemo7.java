package com.neusoft;


import com.mchange.v2.c3p0.util.IsValidOnlyConnectionTester;
import com.neusoft.domain.utils.JDBCUtils;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCDemo7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Scanner类是引用数据类型的一种，我们可以使用该类来完成用户键盘的录入，获取录入的数据
        System.out.println("欢迎来到王者峡谷！");
        System.out.println("请输入你的用户名：");
        String username=scanner.next();
        System.out.println("请输入你的密码：");
        String password=scanner.next();
        boolean flag=login(username,password);
        if(flag){
            System.out.println("欢迎回来，即将进入游戏！");
        }else{
            System.out.println("用户名或者密码错误！请重新登陆");
        }
    }
    /*
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    private static boolean login(String username, String password) {
        //参数检验
        if(username==null||password==null){
         return false;
        }
        Connection conn =null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
        conn=JDBCUtils.getConnection();
        String sql="select * from user where username='"+username+"'and password='"+password+"'";
        stmt =conn.createStatement();
        rs=stmt.executeQuery(sql);
        return rs.next();
        }catch(Exception e){
            e.printStackTrace();

        }
        return false;
    }
}