package movies.service;

/**
 * TODO
 * UserService
 * @author KaYo
 * @date 2019/11/24 - 13:41
 */

import movies.bean.User;
import movies.dao.UserDAO;


public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    /**
     * 检查账号是否存在
     * @param username
     * @return
     */
    public boolean check(String username){
        System.out.println("判断账号");
        boolean flag = userDAO.check(username);
        return flag ;
    }

    /**
     * 添加新用户
     * @param username
     * @param password
     * @return
     */
    public boolean addUser(String username,String password){
        boolean flag = userDAO.addUser(username,password);
        return flag;
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户Bean，失败返回null
     */
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    /**
     * 根据ID查询用户信息
     * @param username
     * @return
     */
    public User getUserByName(String username) {
        return userDAO.getUserByName(username);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

}