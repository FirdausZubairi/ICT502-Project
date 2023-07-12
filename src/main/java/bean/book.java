package bean;

import java.sql.Date;

public class book {
	
	int ticketID;
	int passID;
	int refNo;
	double totalPrice;
	String paymentmethod;
	
	public book(int ticketID, int passID, int refNo, double totalPrice, String paymentmethod) {
		super();
		this.ticketID = ticketID;
		this.passID = passID;
		this.refNo = refNo;
		this.totalPrice = totalPrice;
		this.paymentmethod = paymentmethod;
		
	}
	
	
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public int getPassID() {
		return passID;
	}
	public void setPassID(int passID) {
		this.passID = passID;
	}
	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	
	

}
