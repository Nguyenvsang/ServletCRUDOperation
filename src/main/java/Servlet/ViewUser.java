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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet(name = "viewUser", urlPatterns = {"/viewUser"})
public class ViewUser extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }
    // override the supertype method get
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        // gán giá trị số nguyên cho trang web
        String pageId = request.getParameter("page");
        int total = 3;
        int pagesId = Integer.parseInt(pageId);
        if (pagesId == 1) {
        }
        else {
            pagesId = pagesId - 1;
            pagesId = pagesId * total + 1;
        }
        
        // initializing list of users
        List<User> list = null;
        out.println(
            "<a href='index.html'>Add New Employee</a>");
  
        out.print("<h1> User Table: </h1>");
        out.print(
            "<table border='1' cellpadding='4' width='80%'>");
        out.print("<tr><th>Id</th><th>username</th></tr>");
        try {
            // nhận tất cả người dùng và gán cho trang
            // số
            list = UserDaoHandler.getAllUsers(pagesId,
                                              total);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        // đảm bảo danh sách không rỗng
        if (list != null) {
            // lặp qua danh sách Người dùng
            // Và nhận tên người dùng và id của người dùng.
            for (User user : list) {
                out.print("<tr><td>" + user.getId()
                          + "</td><td>" + user.getUsername()
                          + "</td></tr>");
            }
            
            // in ra ở định dạng web jsp.
            out.print("</table>");
            out.print("<a href='viewUser?page=1'>1</a> ");
            out.print("<a href='viewUser?page=2'>2</a> ");
            out.print("<a href='viewUser?page=3'>3</a> ");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
