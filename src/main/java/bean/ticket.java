package bean;

import java.sql.Date;

public class ticket {
	int ticketID;
	Date ticketDate;
	int destinationID;
	int busID;
	
	public ticket(int ticketID, Date ticketDate, int destinationID, int busID) {
		super();
		this.ticketID = ticketID;
		this.ticketDate = ticketDate;
		this.destinationID = destinationID;
		this.busID = busID;
	}
	
	public ticket ( Date ticketDate, int destinationID, int busID) {
		super();
		this.ticketDate = ticketDate;
		this.destinationID = destinationID;
		this.busID = busID;
	}

	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public Date getTicketDate() {
		return ticketDate;
	}
	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
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
