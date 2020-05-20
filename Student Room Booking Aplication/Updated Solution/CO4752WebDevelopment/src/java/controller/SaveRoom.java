package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import model.Room;
import model.User;

@WebServlet("/SaveRoom")
public class SaveRoom extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String roomId = request.getParameter("roomId");
        String monthlyCharge = request.getParameter("monthlyCharge");
        String roomStatus = request.getParameter("roomStatus");
        String paymentStatus = request.getParameter("paymentStatus");

        Room r = new DAO().getRoom(roomId);
        r.setMonthlyCharge(Integer.parseInt(monthlyCharge));
        r.setPaymentStatus(paymentStatus);
        r.setRoomStatus(roomStatus);

        int status = new DAO().updateRoom(r);
        if (status > 0) {
            out.print("<body bgColor='#344963'>");
            out.print("<center>");
            out.print("<h1 style='color:yellow'>Online Student-Accommodation Management System</h1>");
            out.println("<h1 style='color: white;font-size: 24px;'>Update Room</h1>");
            out.print("</center>");
            out.println("<br/><br/>");
            out.println("<h1 style='color: white;font-size: 24px;'>Update Room Successfully !!!</h1>");
            try {
                Thread.sleep(4000);
                response.sendRedirect("AdminDashboard");
            } catch (Exception ex) {
            }
        } else {
            out.println("Sorry! unable to save record");
            out.print("<body bgColor='#344963'>");
            out.print("<center>");
            out.print("<h1 style='color:yellow'>Online Student-Accommodation Management System</h1>");
            out.println("<h1 style='color: white;font-size: 24px;'>Update Room</h1>");
            out.print("</center>");
            out.println("<br/><br/>");
            out.println("<h1 style='color: white;font-size: 24px;'>Sorry! unable to update record</h1>");
            out.println("<br/><br/>");
            out.println("<a style='color: white;font-size: 18px;text-decoration: none' href='login.html'>Goto Login</a>");
        }

        out.close();
    }

}
