package com.neusoft;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class JDBCDemo3 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiangkeda?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true"
                ,"root","123456");
        String sql="delete from account where id=5";
        Statement stmt = conn.createStatement();
        int i = stmt.executeUpdate(sql);
        if(i==1){
            System.out.println("删除成功");
        }
        else{
            System.out.println("失败");
        }
        stmt.close();
        conn.close();
    }
}

