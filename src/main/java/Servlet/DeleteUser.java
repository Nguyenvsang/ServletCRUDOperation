/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Dao.UserDaoHandler;
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
@WebServlet(name = "deleteUser", urlPatterns = {"/deleteUser"})
public class DeleteUser extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // overriding the supertype method get
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        // get user by id
        String userId = request.getParameter("id");
        
        // the int value of the parameter
          // is parse to the id
        int id = Integer.parseInt(userId);
        try {
            // the delete method is 
              // invoked on user with the
            // specified id
            UserDaoHandler.deleteUser(id);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // it sent the current
         // user view as response
        response.sendRedirect("viewUser?page=1");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
