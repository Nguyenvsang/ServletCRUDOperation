/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Dao.UserDaoHandler;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class AddUser extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // override the supertype method post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        // print object for string formatting
        PrintWriter out = response.getWriter();
        
        // Httpservletrequest get parameters from user
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Thể hiện của lớp User
        User user = new User();
        
        // đặt tham số nhận được cho trường 'Tên người dùng'
        // của lớp Người dùng
        user.setUsername(username);
        user.setPassword(password);
        
        int status =0;
        try {
            // phương thức tĩnh thêm các giá trị được lưu trữ trong
            // đối tượng người dùng vào cơ sở dữ liệu
            status = UserDaoHandler.addUser(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        // kiểm tra xem các giá trị có tương ứng với một không
        // đã chỉ định
        if (status > 0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }
        else {
            out.print("Sorry! unable to save record");
        }
        
        // close database connection
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
