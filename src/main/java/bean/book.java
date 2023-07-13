package bean;

public class book {


	private int ticketID;
	private int passID;
	private String seat;
	private double totalPrice;
	private String paymentMethod;
	


	public book(int ticketID, int passID, String seat, double totalPrice, String paymentMethod) {
		super();
		this.ticketID = ticketID;
		this.passID = passID;
		this.seat = seat;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
	}


	public book(String seat, double totalPrice, String paymentMethod) {

		super();
		this.seat = seat;
		this.totalPrice = totalPrice;
		this.paymentMethod = paymentMethod;
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

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	

	

}
