package com.nf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String SERVER_IP = "123.56.19.150";// 服务器IP地址
    private static final String DATABASE_NAME = "chen";// 连接到哪一个数据库
    private static final String USER_NAME = "root";// 用户名
    private static final String PASSWORD = "Yangluoqi@yang7";// 密码

    public Connection getConnection() {
        Connection conn = null;
        String jdbcUrl = "jdbc:mysql://" + SERVER_IP + ":3306/" + DATABASE_NAME
                + "?serverTimezone=Asia/Shanghai&useSSL=true";
        try {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(jdbcUrl, USER_NAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("获取连接时，异常" + e.getMessage());
            conn = null;
        }
        return conn;
    }
    public void closeAll(Connection conn, PreparedStatement pst, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
