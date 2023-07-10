package bean;

public class booking {
	private int ticketID;
	private int passID;
	private int refNo;
	private double totalprice;
	private String paymentmethod;

	public booking(int ticketID, int passID, int refNo, double totalprice, String paymentmethod) {
		super();
		this.ticketID = ticketID;
		this.passID = passID;
		this.refNo = refNo;
		this.totalprice = totalprice;
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

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

}
