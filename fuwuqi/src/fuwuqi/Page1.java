package fuwuqi;

import java.sql.*;
import java.util.Scanner;

public class Page1 {
 
    // MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://47.56.1.125:3306/user?useSSL=false";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "442765673";
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            Scanner sc = new Scanner(System.in);
            // չ����������ݿ�
            rs.next();
            int id = rs.getInt("user_id");
            String password = rs.getString("user_password");
                // �������r
            int i=0;
            while(i==0) {
	            System.out.println("�������˺�");
	            int id1 = sc.nextInt();
	            sc.nextLine();
	            System.out.println("����������");
	            String password1 = sc.nextLine();

  
                if(id1==id&&password1.equals(password)) {
                	System.out.println("��ȷ");
                	break;}
                else
                	System.out.println("�˺Ż���������");   
            }// ��ɺ�ر�
             System.out.println("ID: " + id);
             System.out.println("pw: " + password);
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}