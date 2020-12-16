package movies.dao;

import movies.bean.Party;
import movies.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 聚游DAO
 * @author KaYo
 * @date 2019/12/3 - 0:56
 */
public class PartyDAO {
    /**
     * 添加出游信息
     * @param address
     * @param perprice
     * @param introduce
     * @param partydate
     * @return
     */
    public boolean add(String address, long perprice, String introduce, String partydate) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into party(address, perprice, introduce, partydate) values (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        boolean flag = true;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, address);
            stmt.setLong(2, perprice);
            stmt.setString(3, introduce);
            stmt.setString(4, partydate);
            int num = stmt.executeUpdate();
            if (num>0){
                System.out.println("success！");
                flag = true;
            } else {
                System.out.println("false！");
                flag = false;
            }
        } catch (Exception e) {
            System.out.println("添加出游信息失败!");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return flag;
    }


    /**
     * 查询出游信息
     * @return
     */
    public Party getParty() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from party where address is not null";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Party party = null;
        try {
            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, address);
            rs = stmt.executeQuery();
            while (rs.next()) {
                party = new Party();
                party.setAddress(rs.getString("address"));
                party.setPerprice(rs.getLong("perprice"));
                party.setIntroduce(rs.getString("introduce"));
                party.setPartydate(rs.getDate("partydate"));
                System.out.println("查询出游信息成功!");
            }
        } catch (SQLException e) {
            System.out.println("查询出游信息失败!");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return party;
    }


    /**
     * 添加报名的用户
     * @param username
     * @param perprice
     * @param phone
     * @return
     */
    public boolean addUser(String username, long perprice, String phone) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into party(username, perprice, phone) values (?, ?, ?)";
        PreparedStatement stmt = null;
        boolean flag = true;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setLong(2, perprice);
            stmt.setString(3, phone);
            int num = stmt.executeUpdate();
            if (num>0){
                System.out.println("成功！");
                flag = true;
            } else {
                System.out.println("失败！");
                flag = false;
            }
        } catch (Exception e) {
            System.out.println("添加出游信息失败!");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return flag;
    }


    /**
     * 查看报名信息
     * @return
     */
    public List<Party> getUser() {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from party where username is not null";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Party> partys = new ArrayList<>();
        Party party = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                party = new Party();
                party.setUsername(rs.getString("username"));
                party.setPerprice(rs.getLong("perprice"));
                party.setPhone(rs.getString("phone"));
                partys.add(party);
                System.out.println("查询用户报名信息成功!");
            }
        } catch (SQLException e) {
            System.out.println("查询用户报名信息失败!");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return partys;
    }
}
