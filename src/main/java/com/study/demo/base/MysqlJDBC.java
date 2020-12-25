package com.study.demo.base;

import java.sql.*;

/**
 * @ClassName MysqlJDBC
 * @Description 使用jdbc
 * @Author dongzhanjun
 * @Date 2020/12/18 14:57
 * @Version 1.0
 */
public class MysqlJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.83.128:3306/dzj?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
        String userName = "root";
        String password = "root";
//        testStatement(url,userName,password);
        testPreparedStatement(url,userName,password);
    }


    public static void testStatement(String url,String userName,String password) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            //加载驱动类~初始化DriverManager
            String driveClassName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driveClassName);
            /**
             *  链接数据库url
             *  protocol//[hosts][/database][?properties]
             * 	protocol：一种连接协议，约定的规则。
             * 	hosts：主机名，通常后跟端口号，例如当前主机默认就是localhost:3306，当然也可以多主机连接，这里暂时不表。
             * 	database:数据库嘛
             */
            //获取链接
            connection = DriverManager.getConnection(url,userName,password);
            if(!connection.isClosed()) System.out.println("Succeeded connecting to the Database!");
            //屏闭事务自动提交
            connection.setAutoCommit(false);
            //创建stateMent对象
            statement = connection.createStatement();
            String sql = "select * from user";
            rs = statement.executeQuery(sql);
            //批量运行sql,增加多个sql
//            statement.addBatch(sql);
//            statement.executeBatch();
            if(rs!=null){
                while (rs.next()){
                    System.out.println(rs.getInt("id"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getInt("age"));
                }
            }
            //提交事务
            connection.commit();
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            connection.rollback();
            //重新设置自动提交
            connection.setAutoCommit(true);
        }finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
                if(statement!=null) {
                    statement.close();
                }
                if(connection!=null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void testPreparedStatement(String url,String userName,String password){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            //加载驱动类~初始化DriverManager
            String driveClassName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driveClassName);
            /**
             *  链接数据库url
             *  protocol//[hosts][/database][?properties]
             * 	protocol：一种连接协议，约定的规则。
             * 	hosts：主机名，通常后跟端口号，例如当前主机默认就是localhost:3306，当然也可以多主机连接，这里暂时不表。
             * 	database:数据库嘛
             */
            //获取链接
            connection = DriverManager.getConnection(url,userName,password);
            if(!connection.isClosed()) System.out.println("Succeeded connecting to the Database!");
            //创建preparedStatement对象~预处理添加数据，其中有两个参数--“？”
            String sql = "insert into user value(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"hehe");
            preparedStatement.setInt(3,20);
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement!=null) {
                    preparedStatement.close();
                }
                if(connection!=null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
