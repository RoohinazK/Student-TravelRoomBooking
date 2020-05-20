package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import model.Room;
import model.User;

@WebServlet("/AdminDashboard")
public class AdminDashboard extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.print("<title>dashboard Room</title>");
        out.print("<body bgColor='#344963'>");
        out.print("<center>");
        out.print("<h1 style='color:yellow'>Online Student-Accommodation Management System</h1>");
        out.println("<h1 style='color: white;font-size: 24px;'>Admin Dashboard</h1>");
        out.print("</center>");
        out.println("<br/><br/>");
        out.println("<a style='color: white;font-size: 18px;text-decoration: none' href='addNewRoom.html'>Add New Room</a>");
        out.println("<br/><br/>");

        out.println("<h1 style='color: white;font-size: 24px;'>Room Details List</h1>");
        out.println("<br/><br/>");
        List<Room> list = new DAO().getAllRoom();

        out.print("<table border='1' width='100%'");
        out.print("<tr><th style='color:yellow'>Room ID</th><th style='color:yellow;padding:10px'>Room Type</th><th style='color:yellow;padding:10px'>Room Location</th><th style='color:yellow;padding:10px'>Monthly Charge</th><th style='color:yellow;padding:10px'>Room Status</th><th style='color:yellow;padding:10px'>Payment Status</th><th style='color:yellow;padding:10px'>Update</th><th style='color:yellow;padding:10px'>Remove</th></tr>");
        for (Room e : list) {
			out.print("<tr><td style='color:white;text-align:center;padding:10px'>"+e.getRoomId()+"</td><td style='color:white;text-align:center'>"+e.getRoomType()+"</td><td style='color:white;text-align:center'>"+e.getRoomLocation()+"</td><td style='color:white;text-align:center'>"+e.getMonthlyCharge()+"</td><td style='color:white;text-align:center'>"+e.getRoomStatus()+"</td><td style='color:white;text-align:center'>"+e.getPaymentStatus()+"</td><td style='text-align:center'><a style='color:white;text-decoration:none' href='UpdateRoom?roomId="+e.getRoomId()+"'>UPDATE</a></td><td style='text-align:center'><a style='color:white;text-decoration:none' href='RemoveRoom?roomId="+e.getRoomId()+"'>REMOVE</a></td></tr>");
        }
        out.print("</table>");
        out.print("</body>");

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }
}
