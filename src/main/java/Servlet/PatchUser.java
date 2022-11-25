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
@WebServlet(name = "patchUser", urlPatterns = {"/patchUser"})
public class PatchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("id");
        int id = Integer.parseInt(userId);
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        try {
            int result = UserDaoHandler.updateUser(user);
            if (result > 0) {
                response.sendRedirect("viewUser? page =1");
            }
            else {
                out.print("unable to connect");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        out.close();
    }
}
