package bean;

public class destination {
	private int destinationID;
	private String destinationName;
	
	public destination(int destinationID, String destinationName) {
		super();
		this.destinationID = destinationID;
		this.destinationName = destinationName;
	}
	
	public destination(String destinationName) {
		super();
		this.destinationName = destinationName;
	}
	
	public destination() {
		
	}

	public int getDestinationID() {
		return destinationID;
	}

	public void setDestinationID(int destinationID) {
		this.destinationID = destinationID;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

}
