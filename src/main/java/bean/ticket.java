package bean;

import java.sql.Date;

public class ticket {
	int ticketID;
	String type;
	Date ticketDate;
	String price;
	int destinationID;
	int busID;
	
	
	public ticket(int ticketID, String type, Date ticketDate, String price, int destinationID, int busID) {
		super();
		this.ticketID = ticketID;
		this.type = type;
		this.ticketDate = ticketDate;
		this.price = price;
		this.destinationID = destinationID;
		this.busID = busID;
	}
	
	public ticket (String type, Date ticketDate, String price) {
		super();
		this.type = type;
		this.ticketDate = ticketDate;
		this.price = price;
	}
	
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}
	public int getBusID() {
		return busID;
	}
	public void setBusID(int busID) {
		this.busID = busID;
	}
	
	

}
