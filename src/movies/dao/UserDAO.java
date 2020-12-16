package movies.dao;

/**
 * TODO
 * 用户DAO
 * @author KaYo
 * @date 2019/11/24 - 13:20
 */


import movies.bean.User;
import movies.common.ConnectionUtil;

import java.sql.*;

/**
 * UserDAO
 *
 * @version 1.0
 */
public class UserDAO {
    /**
     * 检查账号是否存在
     * @param username
     * @return
     */
    public boolean check(String username){
        System.out.println("执行判断");
        //默认账号未被使用
        boolean flag = false;

        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        System.out.println("准备执行");
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //账号已存在
                flag=true;
            }
        } catch (SQLException e) {
            System.out.println("用户查询失败!");
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }

        System.out.println("判断完了");
        return flag;
    }


    /**
     * 添加新用户
     * @param username
     * @param password
     * @return
     */
    public boolean addUser(String username,String password){
        /**
         * 默认注册成功
         */
        boolean flag = true ;

        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        String addsql = "Insert INTO user(username,password) VALUES(?,?)";
        try {
            stmt = conn.prepareStatement(addsql);
            stmt.setString(1,username);
            stmt.setString(2,password);

            int num = stmt.executeUpdate();

            if(num > 0){
                flag = true;
                System.out.println("num>0");
            }else {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionUtil.release(stmt, conn);
        }
        return flag;
    }


    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户Bean，失败返回null
     */
    public User login(String username, String password) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRealName(rs.getString("realname"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("登录失败!");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return user;
    }


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User getUserByName(String username) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRealName(rs.getString("realname"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                System.out.println("查询用户信息成功!");
            }
        } catch (SQLException e) {
            System.out.println("查询用户信息失败!");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return user;
    }


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE user SET username = ?, password = ?, realname = ?, birthday = ?, phone = ?, address = ? WHERE username = ? and password = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRealName());
            stmt.setDate(4, new Date(user.getBirthday().getTime()));
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getName());
            stmt.setString(8, user.getPassword());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("修改用户信息失败!");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }

}