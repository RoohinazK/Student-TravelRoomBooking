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

@WebServlet("/UpdateRoom")
public class UpdateRoom extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<body bgColor='#344963'>");
        out.print("<center>");
        out.print("<h1 style='color:yellow'>Online Student-Accommodation Management System</h1>");
        out.println("<h1 style='color: white;font-size: 24px;'>Admin Dashboard</h1>");
        out.print("</center>");
        out.println("<br/><br/>");

        out.println("<h1 style='color: white;font-size: 24px;'>Update Room Details</h1>");
        String sid = request.getParameter("roomId");

        Room room = new DAO().getRoom(sid);

        out.print("<title>update room</title>");
        out.print("<form action='SaveRoom' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='roomId' value='"+room.getRoomId()+"'/></td></tr>");
		out.print("<tr><td style='color: white;font-size: 18px; width: 150px; height: 50px'>Monthly Payment:</td><td><input style='width: 200px;height: 30px;font-size: 16px;font-weight: 500;background: #394963; border: white 2px solid; border-radius: 15px;color: yellow; padding-left: 10px' type='text' name='monthlyCharge' value='"+room.getMonthlyCharge()+"' required/></td></tr>");
		out.print("<tr><td style='color: white;font-size: 18px; width: 150px; height: 50px'>Room Status:</td><td><input style='width: 200px;height: 30px;font-size: 16px;font-weight: 500;background: #394963; border: white 2px solid; border-radius: 15px;color: yellow; padding-left: 10px' type='text' name='roomStatus' value='"+room.getRoomStatus()+"' required/></td></tr>");
		out.print("<tr><td style='color: white;font-size: 18px; width: 150px; height: 50px'>Payment Status:</td><td><input style='width: 200px;height: 30px;font-size: 16px;font-weight: 500;background: #394963; border: white 2px solid; border-radius: 15px;color: yellow; padding-left: 10px' type='text' name='paymentStatus' value='"+room.getPaymentStatus()+"' required/></td></tr>");
		out.print("<tr><td style='height:30px'></td></tr>");
                out.print("<tr><td colspan='2'><input style='width: 200px;height: 40px;font-size: 18px;font-weight: bold;background: #394963; border: white 2px solid; border-radius: 15px;color: yellow' type='submit' value='Update &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
        out.print("</body>");

        out.close();
    }
}
