package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DAO dao;

    public UserController() {
        dao = new DAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionControl = (String) request.getParameter("action");
        PrintWriter out = response.getWriter();
        String emailId, password, type;

        if (actionControl.equalsIgnoreCase("login")) {
            emailId = (String) request.getParameter("emailId");
            password = (String) request.getParameter("password");
            type = (String) request.getParameter("type");
            boolean check = dao.login(emailId, password, type);
            if (check) {
//					response.sendRedirect("AdminDashboard");
                out.println("<p style='color: white;font-size: 18px; width: 250px; height: 10px'>Login Successfully !!! </p><br/>");
                out.println("<a style='color: white;font-size: 18px;text-decoration: none'    href='AdminDashboard'>Display Dashboard</a>");
            } else {
                out.println("<p style='color: white;font-size: 18px; width: 300px; height: 10px'>Sorry! unable to login user </p><br/>");
                out.println("<a style='color: white;font-size: 18px;text-decoration: none'    href='register.html'>Goto Register</a>");
            }

        }

        if (actionControl.equalsIgnoreCase("register")) {
            emailId = (String) request.getParameter("emailId");
            password = (String) request.getParameter("password");
            type = (String) request.getParameter("type");
            dao.register(emailId, password, type);
            response.sendRedirect("AdminDashboard");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

}
