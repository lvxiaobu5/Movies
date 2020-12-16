package movies.common;

/**
 * TODO
 * 数据库操作公共类
 * @author KaYo
 * @date 2019/11/21 - 23:25
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class ConnectionUtil {

    private static String url = "jdbc:mysql://localhost:3306/movies";

    private static String user = "root";

    private static String password = "199896";

    private ConnectionUtil() {}

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类，加载驱动失败!");
            e.printStackTrace();
        }
    }

    /**
     * 获得数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败!");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放数据库资源
     * @param rs ResultSet
     * @param stmt Statement
     * @param conn Connection
     */
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 资源释放的方法
     * @param stmt 要释放的执行 sql 语句的对象
     * @param conn 要释放的连接对象
     */
    public static void release(Statement stmt, Connection conn) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }

    }
}