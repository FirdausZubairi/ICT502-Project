package bean;

public class BusDest {
	private int busID;
	private String name;
	private String noPlate;
	private int destinationID;
	private String destinationName;
	private String time;
	
	public BusDest(int busID, String name, String noPlate, int destinationID, String destinationName, String time ) {
		super();
		this.busID = busID;
		this.name = name;
		this.noPlate = noPlate;
		this.destinationID = destinationID;
		this.destinationName = destinationName;
		this.time = time;
	}
	public BusDest(int busID, String name, String noPlate, int destinationID, String destinationName ) {
		super();
		this.busID = busID;
		this.name = name;
		this.noPlate = noPlate;
		this.destinationID = destinationID;
		this.destinationName = destinationName;
	}

	public int getBusID() {
		return busID;
	}

	public void setBusID(int busID) {
		this.busID = busID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNoPlate() {
		return noPlate;
	}

	public void setNoPlate(String noPlate) {
		this.noPlate = noPlate;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
