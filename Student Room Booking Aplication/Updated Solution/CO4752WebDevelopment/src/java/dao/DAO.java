package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Room;
import util.DBConnection;

public class DAO {

	
	private Connection con;
	
	public DAO()
	{
		try {
		con = DBConnection.getConnection();
		}
		catch(Exception ex)
		{
			System.out.println("Unable to connect Database Error: "+ex.getMessage());
		}
		
	}
	
	
	public int addNewRoom(Room room)
	{
		System.out.println("dao add addNewRoom");
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into room(roomId,roomType,roomLocation,monthlyCharge,roomStatus,paymentStatus,email) values(?,?,?,?,?,?,?)");
			ps.setString(1,room.getRoomId());
			ps.setString(2,room.getRoomType());
			ps.setString(3,room.getRoomLocation());
			ps.setInt(4,room.getMonthlyCharge());
			ps.setString(5,room.getRoomStatus());
                        ps.setString(6,room.getPaymentStatus());
			ps.setString(7,room.getEmail());
			i = ps.executeUpdate();
			System.out.print(i);
		}
		catch(Exception ex)
		{}
		return i;
	}
	
	public void deleteRoom(String roomId)
	{
		try {
			PreparedStatement ps = con.prepareStatement("delete from room where roomId=?");
			ps.setString(1,roomId);
			ps.executeUpdate();
		}
		catch(Exception ex)
		{}
	}
	
	public int updateRoom(Room r)
	{
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("update room set monthlyCharge=?,roomStatus=?,paymentStatus=? where roomId=?");
			ps.setInt(1,r.getMonthlyCharge());
			ps.setString(2,r.getRoomStatus());
			ps.setString(3,r.getPaymentStatus());
                        ps.setString(4,r.getRoomId());
			i = ps.executeUpdate();
		
		}
		catch(Exception ex)
		{}
		return i;
	}
	
	public List<Room> getAllRoom()
	{
		List<Room> list = new ArrayList<Room>();
		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from room");
			while(rs.next())
			{
				String roomId = rs.getString(1);
				String roomTYpe = rs.getString(2);
				String roomLocation = rs.getString(3);
				int monthlyCharge = rs.getInt(4);
				String roomStatus = rs.getString(5);
                                String paymentStatus = rs.getString(6);
                                String email = rs.getString(7);
                                
                                Room r = new Room(roomId, roomTYpe, roomLocation, email);
                                r.setMonthlyCharge(monthlyCharge);
                                r.setRoomStatus(roomStatus);
                                r.setPaymentStatus(paymentStatus);
				list.add(r);
			}
		}
		catch(Exception ex)
		{}
		return list;
	}
	
	public Room getRoom(String id)
	{
		Room r = null;
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from room");
			while(rs.next())
			{
				String roomId = rs.getString(1);
				String roomTYpe = rs.getString(2);
				String roomLocation = rs.getString(3);
				int monthlyCharge = rs.getInt(4);
				String roomStatus = rs.getString(5);
                                String paymentStatus = rs.getString(6);
                                String email = rs.getString(7);
                                
                                
				if(roomId.equals(id))
				{
                                    r = new Room(roomId, roomTYpe, roomLocation, email);
                                    r.setMonthlyCharge(monthlyCharge);
                                    r.setRoomStatus(roomStatus);
                                    r.setPaymentStatus(paymentStatus);
                                    break;
				}
			}
		}
		catch(Exception ex)
		{
                }
		return r;
	}
	
	public void register(String emailId, String password, String type)
	{
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into user(email,password, type) values(?,?,?)");
			ps.setString(1, emailId);
			ps.setString(2, password);
                        ps.setString(3, type);
			ps.executeUpdate();
		}
		catch(Exception ex)
		{}
	}
	
	public boolean login(String emailId, String password, String type)
	{
		boolean check = false;
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next())
			{
				String email = rs.getString(1);
				String pass = rs.getString(2);
                                String ty = rs.getString(3);
				
				if(email.equals(emailId) && pass.equals(password) && ty.equalsIgnoreCase(type))
				{
                                    
					check = true;
					break;
				}
			}
		}
		catch(Exception ex)
		{}
		return check;
	}
	
}
