package fuwuqi;

import java.sql.*;
import java.util.Scanner;

public class Page1 {
 
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://47.56.1.125:3306/user?useSSL=false";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "442765673";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            Scanner sc = new Scanner(System.in);
            // 展开结果集数据库
            rs.next();
            int id = rs.getInt("user_id");
            String password = rs.getString("user_password");
                // 输出数据r
            int i=0;
            while(i==0) {
	            System.out.println("请输入账号");
	            int id1 = sc.nextInt();
	            sc.nextLine();
	            System.out.println("请输入密码");
	            String password1 = sc.nextLine();

  
                if(id1==id&&password1.equals(password)) {
                	System.out.println("正确");
                	break;}
                else
                	System.out.println("账号活或密码错误");   
            }// 完成后关闭
             System.out.println("ID: " + id);
             System.out.println("pw: " + password);
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}