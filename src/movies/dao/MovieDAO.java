package movies.dao;

import movies.bean.Movie;
import movies.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 电影列表DAO
 * @author KaYo
 * @date 2019/11/21 - 23:22
 */
public class MovieDAO {
    /**
     * 添加电影信息
     * @param
     * @return
     */
    public boolean save(String moviename,String picpath,String introduce,String filename) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into movieslist(moviename, picpath, introduce,filename) values (?, ?, ?, ?)";
        PreparedStatement stmt = null;
        boolean flag = true;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, moviename);
//            stmt.setLong(2, movie.getUserId());
            stmt.setString(2, picpath);
            stmt.setString(3, introduce);
            stmt.setString(4, filename);
            int num = stmt.executeUpdate();
            if (num>0){
                System.out.println("success");
                flag = true;
            } else {
                System.out.println("false");
                flag = false;
            }
        } catch (Exception e) {
            System.out.println("添加电影信息失败!");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return flag;
    }


    /**
     * 显示全部电影
     * @return
     */
    public List<Movie> getMovies(){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from movieslist order by id desc";//limit m, n：从第m条开始，取出总共n条记录
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getString("moviename"),
                        rs.getString("picpath"),
                        rs.getString("introduce"),
                        rs.getString("filename")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return movies;
    }


    /**
     * 分页查询全部电影
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public List<Movie> getPage(int page,int pageSize){
        Connection conn = ConnectionUtil.getConnection();

        String sql = "select * from movieslist order by id desc limit ?, ?";//limit m, n：从第m条开始，取出总共n条记录
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Movie> movies = new ArrayList<>();//接收返回值
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, (page - 1) * pageSize);
            stmt.setInt(2, pageSize);
            rs = stmt.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(rs.getLong("id"),
                        rs.getString("moviename"),
                        rs.getString("picpath"),
                        rs.getString("introduce"),
                        rs.getString("filename")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return movies;
    }


    /**
     * 计算所有电影数量
     * @return
     */
    public int countMovies(){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select count(*) total from movieslist";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return 0;
    }


    /**
     * 电影详情
     * @param moviename
     * @return
     */
    public Movie movieDetail(String moviename){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from movieslist where moviename = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        List<Movie> movies = new ArrayList<>();
        Movie movie = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, moviename);
            rs = stmt.executeQuery();
            while (rs.next()) {
                movie = new Movie();
                movie.setIntroduce(rs.getString("introduce"));
                movie.setMoviename(rs.getString("moviename"));
                movie.setFilename(rs.getString("filename"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return movie;
    }


    /**
     * 修改电影信息
     * @param
     * @return
     */
    public boolean update(String moviename,String picpath,String introduce,String filename) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE movieslist SET picpath = ?, introduce = ?, filename = ? where moviename = ?";
        PreparedStatement stmt = null;
        boolean flag;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, picpath);
            stmt.setString(2, introduce);
            stmt.setString(3, filename);
            stmt.setString(4, moviename);
            int num = stmt.executeUpdate();
            if (num>0){
                System.out.println("success");
                flag = true;
            } else {
                System.out.println("false!");
                flag = false;
            }
        } catch (Exception e) {
            System.out.println("修改电影信息失败!");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return flag;
    }


    /**
     * 删除电影信息
     * @param
     * @return
     */
    public boolean delete(String moviename) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "DELETE FROM movieslist WHERE moviename = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Movie movie = null;
        boolean flag = true;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, moviename);
//            stmt.setLong(2, movie.getUserId());
//            stmt.setString(2, picpath);
//            stmt.setString(3, introduce);
//            stmt.setString(4, filename);
            int num = stmt.executeUpdate();
            if (num>0){
                flag = true;
                System.out.println("删除电影信息成功!");
            } else {
                System.out.println("false");
                flag = false;
            }
        } catch (Exception e) {
            System.out.println("删除电影信息失败!");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return flag;
    }


    /**
     * 显示单部电影
     * @return
     */
    public Movie getMovie(String moviename){
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from movieslist where moviename=?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
//        List<Movie> movies = new ArrayList<>();
        Movie movie = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,moviename);
            rs = stmt.executeQuery();
            while (rs.next()) {
                movie = new Movie();
                movie.setMoviename(rs.getString("moviename"));
                movie.setPicpath(rs.getString("picpath"));
                movie.setFilename(rs.getString("filename"));
                movie.setIntroduce(rs.getString("introduce"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return movie;
    }


    /**
     * 根据电影名查询电影详情
     * @param moviename
     * @return
     */
    public Movie getMovieByName(String moviename) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from movieslist where moviename = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Movie movie = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, moviename);
            rs = stmt.executeQuery();
            while (rs.next()) {
                movie = new Movie();
                movie.setMoviename(rs.getString("moviename"));
                movie.setPicpath(rs.getString("picpath"));
                movie.setIntroduce(rs.getString("introduce"));
                movie.setFilename(rs.getString("filename"));
                System.out.println("查询电影信息成功!");
            }
        } catch (SQLException e) {
            System.out.println("查询电影信息失败!");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return movie;
    }
}
