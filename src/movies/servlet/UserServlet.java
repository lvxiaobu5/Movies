package movies.servlet;

/**
 * TODO
 * 用户Servlet
 * @author KaYo
 * @date 2019/11/25 - 2:59
 */

import movies.bean.User;
import movies.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;


public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/userInfo.do", pathName)) {
            request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
        } else if (Objects.equals("/editUserPrompt.do", pathName)) {
            //1.从Session中获取，其实就是与上一个if同样的方式
            //2.可扩展的使用方式：根据页面ID从数据库中查询
//            Long id = Long.valueOf(request.getParameter("id"));
            String username = request.getParameter("username");
            System.out.println(username);
            User user = userService.getUserByName(username);
            if (null != user) {
                request.setAttribute("user", user);
                System.out.println("用户存在，跳转到修改信息页面！");
                request.getRequestDispatcher("/WEB-INF/views/biz/edit_user.jsp").forward(request, response);
            } else {
                System.out.println("跳转失败！");
                request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
            }
        } else if (Objects.equals("/editUser.do", pathName)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String realName = request.getParameter("realName");
            String birthday = request.getParameter("birthday");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setRealName(realName);
            try {
                user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
            } catch (ParseException e) {
                System.out.println("格式化Birthday字段失败!");
                e.printStackTrace();
            }
            user.setPhone(phone);
            user.setAddress(address);
            boolean result = userService.updateUser(user);
            if (result) {
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/views/biz/user.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        } else if (Objects.equals("/admin.do", pathName)){
            request.getRequestDispatcher("/WEB-INF/views/biz/admin.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
        }
    }

}
