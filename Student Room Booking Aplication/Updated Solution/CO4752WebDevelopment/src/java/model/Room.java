package model;


public class Room {
    
    private String roomId;
    private String roomType;
    private String roomLocation;
    private int monthlyCharge;
    private String roomStatus;
    private String paymentStatus;
    private String email;

    
    public Room()
    {}
    
    public Room(String roomId, String roomType, String roomLocation, String email) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomLocation = roomLocation;
        this.monthlyCharge = 150;
        this.roomStatus = "Available";
        this.paymentStatus = "Pending";
        this.email = email;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public int getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(int monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
